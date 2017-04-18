package com.hsbc.puppetknight.command;

/**
 * Created by mistapostle on 17/4/8.
 */
public abstract class AbstractCommand implements Command {
    @Override
    public void exec(Object target, Object... args) throws CommandExectionError {
        try {
            doExec(target,args);
        }catch(Exception e){
            //TODO: more info to input to this
            throw new CommandExectionError(e);
        }
    }

    protected abstract void doExec(Object target, Object... args) throws Exception;

}
