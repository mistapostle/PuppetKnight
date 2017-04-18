package com.hsbc.puppetknight.loader;

import com.hsbc.puppetknight.command.Command;
import com.hsbc.puppetknight.model.Step;

/**
 * Created by mistapostle on 17/4/17.
 */
public interface CommandLoader {
    Command load(String command);
}
