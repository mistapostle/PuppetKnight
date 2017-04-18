package com.hsbc.puppetknight.runner;

import com.google.common.collect.ImmutableList;
import com.hsbc.puppetknight.command.CommandExectionError;
import com.hsbc.puppetknight.model.Case;
import com.hsbc.puppetknight.model.Step;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by mistapostle on 17/4/8.
 */
public class CaseRunnerTest {
    private WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mistapostle/Jam_Tools/Selenium/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(10000);  // Let the user actually see something!

    }

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, CommandExectionError {
        Case aCase = new Case( new ImmutableList.Builder<Step>()
                .add(new Step("click","//*[@id=\"su\"]",""))
                .add(new Step("clearAndInput","//*[@id=\"kw\"]","nice")).build());
        CaseRunner c = new CaseRunner(driver,aCase);
        c.run();
    }
}
