package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmModel;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmParameters;
import org.junit.Test;

public class SvmModelTest {

    @Test
    public void callScriptTest() {
        SvmParameters svmParameters = new SvmParameters.SvmPropertiesBuilder().build();
        SvmModel svmModel = new SvmModel(svmParameters);
        String[] scriptName = svmModel.buildScriptCall();

//        PythonBusiness pythonBusiness = new PythonBusiness();
//        pythonBusiness.startProcess(scriptName);

    }
}
