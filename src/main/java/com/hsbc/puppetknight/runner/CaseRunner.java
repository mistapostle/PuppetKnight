package com.hsbc.puppetknight.runner;

import com.google.common.collect.ImmutableMap;
import com.hsbc.puppetknight.command.Command;
import com.hsbc.puppetknight.command.CommandExectionError;
import com.hsbc.puppetknight.command.base.ClearAndInputCommand;
import com.hsbc.puppetknight.command.base.ClickCommand;
import com.hsbc.puppetknight.model.Case;
import com.hsbc.puppetknight.model.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class CaseRunner{
    private static Map<String,Command> COMMAND_MAP;

    static {
            COMMAND_MAP = new ImmutableMap.Builder<String, Command>()
                    .put("click", new ClickCommand())
                    .put("clearAndInput", new ClearAndInputCommand())
                    .build();
    }

    private Case aCase;

    private WebDriver driver;

    public CaseRunner(WebDriver driver,Case aCase) {
        this.aCase = aCase;
        this.driver = driver;
    }

    public void run() throws CommandExectionError {
        for( Step s : aCase.getSteps()){
            WebElement e =  driver.findElement(By.xpath(s.getTarget()));
            COMMAND_MAP.get(s.getCommand()).exec(e, s.getValue());

        }
    }

}
