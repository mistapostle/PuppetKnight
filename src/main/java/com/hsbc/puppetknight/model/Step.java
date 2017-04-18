package com.hsbc.puppetknight.model;

/**
 * Created by mistapostle on 17/4/8.
 */
public class Step {
    private String command;
    private String target;
    private String value;

    public Step(String command, String target, String value) {
        this.command = command;
        this.target = target;
        this.value = value;
    }

    public Step() {
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
