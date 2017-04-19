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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Step step = (Step) o;

        if (!command.equals(step.command)) return false;
        if (target != null ? !target.equals(step.target) : step.target != null) return false;
        return value != null ? value.equals(step.value) : step.value == null;
    }

    @Override
    public int hashCode() {
        int result = command.hashCode();
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Step{" +
                "command='" + command + '\'' +
                ", target='" + target + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
