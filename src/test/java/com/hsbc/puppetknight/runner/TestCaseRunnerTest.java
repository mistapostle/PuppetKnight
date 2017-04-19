package com.hsbc.puppetknight.runner;

import com.google.common.collect.ImmutableList;
import com.hsbc.puppetknight.command.CommandExectionError;
import com.hsbc.puppetknight.loader.ClassNameCommandLoader;
import com.hsbc.puppetknight.loader.CsvFileCaseLoader;
import com.hsbc.puppetknight.loader.LoaderException;
import com.hsbc.puppetknight.model.TestCase;
import com.hsbc.puppetknight.model.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by mistapostle on 17/4/8.
 */
public class TestCaseRunnerTest {
    private WebDriver driver;
    private static ClassNameCommandLoader commandLoader ;
    @BeforeClass
    public static void beforeClass(){
        commandLoader = new ClassNameCommandLoader();
        commandLoader.loadPackage("com.hsbc.puppetknight.command;");
    }
    @Before
    public void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mistapostle/Jam_Tools/Selenium/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(10000);  // Let the user actually see something!

    }

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, CommandExectionError {
        TestCase aTestCase = new TestCase( new ImmutableList.Builder<Step>()
                .add(new Step("click","//*[@id=\"su\"]",""))
                .add(new Step("clearAndInput","//*[@id=\"kw\"]","nice")).build());
        CaseRunner c = new CaseRunner(commandLoader,driver, aTestCase);
        c.run();
    }
    @Test
    public void testWithCsvCase() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, CommandExectionError, LoaderException {
        CsvFileCaseLoader loader = new CsvFileCaseLoader(new File("example/case/csv"));
        TestCase acase = loader.load("1");
        CaseRunner c = new CaseRunner(commandLoader,driver, acase);
        c.run();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(10*1000);
        driver.quit();
    }
}
