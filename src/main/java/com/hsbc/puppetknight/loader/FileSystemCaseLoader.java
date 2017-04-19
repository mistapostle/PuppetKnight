package com.hsbc.puppetknight.loader;

import com.hsbc.puppetknight.model.TestCase;

import java.io.File;

import static com.google.common.base.Preconditions.checkArgument;
/**
 * Created by mistapostle on 17/4/19.
 */
public abstract class FileSystemCaseLoader implements CaseLoader{

    private File basePath ;

    public FileSystemCaseLoader(File basePath){
        checkArgument( basePath.exists(),"basePath %s is not exists",basePath);
        checkArgument( basePath.isDirectory(),"basePath should be a directory %s", basePath);
        this.basePath = basePath;
    }

    @Override
    public TestCase load(String caseId) throws LoaderException {
        File target = new File(basePath,caseId + "." + getExt());
        if(target.exists() && !target.isDirectory()){
            return doLoad(target);
        }
        return null;
    }

    protected abstract TestCase doLoad(File target) throws LoaderException ;

    protected abstract  String getExt()  ;
}
