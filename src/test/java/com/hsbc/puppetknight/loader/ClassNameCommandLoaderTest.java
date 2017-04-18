package com.hsbc.puppetknight.loader;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.hsbc.puppetknight.command.Command;
import com.hsbc.puppetknight.command.base.ClearAndInputCommand;
import com.hsbc.puppetknight.command.base.ClearCommand;
import com.hsbc.puppetknight.loader.ClassNameCommandLoader;
import com.hsbc.puppetknight.util.RefelectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by mistapostle on 17/4/18.
 */
public class ClassNameCommandLoaderTest {
    @Test
    public void testClasspathLoad() throws IOException {
        ClassPath cp = ClassPath.from(Thread.currentThread().getContextClassLoader());
        ImmutableSet<ClassPath.ClassInfo> classz = cp.getTopLevelClassesRecursive("com.hsbc.puppetknight.command");
        for(ClassPath.ClassInfo c : classz){
            System.out.println("cp = " + c);
        }
    }
    @Test
    public void testInstanceOf() {
        Assert.assertTrue(Command.class.isAssignableFrom( ClearCommand.class));

        List<Class<? extends Command>> list = RefelectionUtils.getImplementedClass("com.hsbc.puppetknight.command", Command.class);
        for(Class<? extends Command > c : list){
            System.out.println("found command : " + c.getName());
        }
    }
    @Test
    public void testLoadBasePackage(){
        ClassNameCommandLoader loader = new ClassNameCommandLoader();
        loader.loadPackage("com.hsbc.puppetknight.command.base");
        Command c = loader.load("clear");
        Assert.assertTrue(c.getClass() == ClearCommand.class);
        Assert.assertTrue(loader.load("clearAndInput").getClass() == ClearAndInputCommand.class);

    }

}