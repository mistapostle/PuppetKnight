package com.hsbc.puppetknight.loader;

import com.hsbc.puppetknight.model.Step;
import com.hsbc.puppetknight.model.TestCase;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mistapostle on 17/4/19.
 */
public class CsvFileCaseLoader extends FileSystemCaseLoader {

    public CsvFileCaseLoader(File basePath) {
        super(basePath);
    }

    @Override
    protected TestCase doLoad(File target) throws LoaderException {
        Reader in = null;
        TestCase testCase = new TestCase(  );
        List<Step> steps = new ArrayList<Step>();
        testCase.setSteps(steps);
        try {
            in = new FileReader(target);
        } catch (FileNotFoundException e) {
            throw new LoaderException("File not exits:" + target , e);
        }
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        } catch (IOException e) {
            throw new LoaderException("Cannot parse file :" + target , e);
        }

        for (CSVRecord record : records) {
            String command = record.get("Command");
            String t = record.get("Target");
            String value = record.get("Value");
            steps.add(new Step(command,t,value));
        }

        return testCase;
    }

    @Override
    protected String getExt() {
        return "csv";
    }
}
