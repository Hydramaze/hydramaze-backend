package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

public class SimplePythonCall {

    @Test
    public void callScriptTest() {
        PythonRequest pythonRequest = new PythonRequest("pocArgumentsClassifier.py");

        pythonRequest.addArgumentWithName("test_size", 0.5)
                .addArgumentWithName("verbose", true)
                .addArgumentWithName("kernel", "rbf")
                .addArgumentWithName("dataset", "breast_cancer");

        PythonBusiness pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcessCall(pythonRequest);
        //System.out.println(pythonBusiness.getJsonObjectResult().toString());
    }

}
