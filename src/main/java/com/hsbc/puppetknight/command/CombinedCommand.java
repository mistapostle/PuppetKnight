package com.hsbc.puppetknight.command;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;

/**
 * Created by mistapostle on 17/4/8.
 */
public abstract class CombinedCommand implements Command {
    private ImmutableList<Command> commands;
    private ImmutableList<int[]> commandArgIndexs ;
    public CombinedCommand(ImmutableList<Command> commands, ImmutableList<int[]> commandArgIndexs) {
        this.commands = commands;
        this.commandArgIndexs = commandArgIndexs;
    }

    @Override
    public void exec(Object target, Object... args) throws CommandExectionError {
        int i = 0 ;
        for(Command c : commands){
            c.exec(target,fetchArgs(i, args));
            i++;
        }
    }

    private Object[] fetchArgs(int i, Object[] args) {
        int[] is = commandArgIndexs.get(i);
        Object[] result = new Object[is.length];
        int j = 0 ;
        for(int x : is){
            result[j] = args[x];
            j++;
        }
        return result;
    }
}
