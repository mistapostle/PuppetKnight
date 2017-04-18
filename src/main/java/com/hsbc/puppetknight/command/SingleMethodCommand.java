package com.hsbc.puppetknight.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mistapostle on 17/4/8.
 */
public abstract class SingleMethodCommand extends AbstractCommand  {
    private Method m ;


    @Override
    protected void doExec(Object target, Object... args) throws Exception {
        m.invoke(target,args);
    }
}
