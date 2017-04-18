package com.hsbc.puppetknight.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mistapostle on 17/4/18.
 */
public class RefelectionUtils {
    public static <T> List<Class <? extends T>> getImplementedClass(String packageName, Class<T> clazz){
        ClassPath cp = null;
        List<Class<? extends  T>> rs = new ArrayList<>();

        try {
            cp = ClassPath.from(Thread.currentThread().getContextClassLoader());
            ImmutableSet<ClassPath.ClassInfo> classz = cp.getTopLevelClassesRecursive("com.hsbc.puppetknight.command");
            for(ClassPath.ClassInfo i : classz){
                Class<?> c = i.load();
                if( clazz.isAssignableFrom(c) &&  !c.isInterface() && !Modifier.isAbstract(c.getModifiers())){
                    rs.add((Class<? extends T>) c );
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rs ;
    }
}
