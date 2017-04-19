package com.hsbc.puppetknight.loader;

import com.hsbc.puppetknight.model.TestCase;

/**
 * Created by mistapostle on 17/4/19.
 */
public interface CaseLoader {
    public TestCase load(String caseId) throws LoaderException ;
}
