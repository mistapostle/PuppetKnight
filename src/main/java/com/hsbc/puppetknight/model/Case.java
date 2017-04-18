package com.hsbc.puppetknight.model;

import java.util.List;

/**
 * Created by mistapostle on 17/4/8.
 */
public class Case {
    private List<Step> steps ;

    public Case(List<Step> steps) {
        this.steps = steps;
    }
    public Case(){}

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
