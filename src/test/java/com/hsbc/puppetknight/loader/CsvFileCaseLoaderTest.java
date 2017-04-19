package com.hsbc.puppetknight.loader;

import com.hsbc.puppetknight.model.Step;
import com.hsbc.puppetknight.model.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import static org.junit.Assert.assertEquals;

/**
 * Created by mistapostle on 17/4/19.
 */
public class  CsvFileCaseLoaderTest {

    @Test
    public void testLoadExample() throws LoaderException {
        CsvFileCaseLoader loader = new CsvFileCaseLoader(new File("example/case/csv"));
        TestCase c = loader.load("1");
        assertEquals( 2,c.getSteps().size() );
        Step step1 = new Step("clearAndInput","//*[@id=\"kw\"]","Good");
        assertEquals( c.getSteps().get(1),  step1);
    }
}
