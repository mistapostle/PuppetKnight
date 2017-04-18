package com.hsbc.puppetknight.loader;

import com.hsbc.puppetknight.command.Command;
import com.hsbc.puppetknight.util.RefelectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mistapostle on 17/4/17.
 */
public class ClassNameCommandLoader implements CommandLoader {
    private Map<String,   Command> commandMap= new HashMap<String,  Command>();
    public void loadPackage(String packageName){


        List<Class<? extends Command>> subTypes = RefelectionUtils.getImplementedClass(packageName, Command.class); //reflections.getSubTypesOf(Command.class);
        for(Class<? extends Command> c : subTypes){
           if(c.isInterface() || Modifier.isAbstract( c.getModifiers())){
               continue;
           }
           String name = c.getSimpleName().toLowerCase();
           if(name.toUpperCase().endsWith("COMMAND") && name.length()> "COMMAND".length() ) {
               name = name.substring(0, name.length() - "COMMAND".length());
           }
           try {
               commandMap.put(name,c.getConstructor().newInstance());
           } catch (InstantiationException e) {
               //log error
//               e.printStackTrace();
           } catch (IllegalAccessException e) {
//               e.printStackTrace();
           } catch (InvocationTargetException e) {
//               e.printStackTrace();
           } catch (NoSuchMethodException e) {
//               e.printStackTrace();
           }
       }
    }
    @Override
    public Command load(String name) {
        return commandMap.get(name.toLowerCase());
    }
}
