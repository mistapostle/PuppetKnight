package com.hsbc.puppetknight.runner;

import com.hsbc.puppetknight.command.CommandExectionError;
import com.hsbc.puppetknight.loader.CommandLoader;
import com.hsbc.puppetknight.model.TestCase;
import com.hsbc.puppetknight.model.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaseRunner{
    private CommandLoader commandLoader ;

    private TestCase aTestCase;

    private WebDriver driver;

    public CaseRunner(CommandLoader commandLoader,WebDriver driver,TestCase aTestCase) {
        this.commandLoader = commandLoader;
        this.aTestCase = aTestCase;
        this.driver = driver;
    }

    public void run() throws CommandExectionError {
        for( Step s : aTestCase.getSteps()){
            WebElement e =  driver.findElement(By.xpath(s.getTarget()));
            commandLoader.load(s.getCommand()).exec(e, s.getValue());

        }
    }

}
