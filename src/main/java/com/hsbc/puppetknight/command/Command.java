package com.hsbc.puppetknight.command;

/**
 * Created by mistapostle on 17/4/8.
 */
public interface Command {
    public void exec(Object target,Object... args) throws CommandExectionError;
}
