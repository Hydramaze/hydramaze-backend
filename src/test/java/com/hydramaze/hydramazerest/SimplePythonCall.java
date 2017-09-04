package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

public class SimplePythonCall {

    @Test
    public void callScriptTest() {
        PythonRequest pythonRequest = new PythonRequest("pocArgumentsClassifier.py");

        pythonRequest.addArgumentWithName("verbose", true)
                .addArgumentWithName("kernel", "rbf");

        PythonBusiness pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcessCall(pythonRequest);
    }

}
