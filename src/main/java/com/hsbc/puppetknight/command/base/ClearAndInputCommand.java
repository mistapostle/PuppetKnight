package com.hsbc.puppetknight.command.base;

import com.google.common.collect.ImmutableList;
import com.hsbc.puppetknight.command.CombinedCommand;
import com.hsbc.puppetknight.command.Command;

/**
 * Created by mistapostle on 17/4/8.
 */
public class ClearAndInputCommand extends CombinedCommand {
    public ClearAndInputCommand() {
        super(new ImmutableList.Builder<Command>().add(new ClearCommand()).add(new InputCommand()).build(),
                new ImmutableList.Builder<int[]>().add(new int[0], new int[]{0}).build());
    }
}
