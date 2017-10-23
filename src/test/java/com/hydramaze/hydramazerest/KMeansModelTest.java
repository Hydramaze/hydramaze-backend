package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

public class KMeansModelTest {

    @Test
    public void callScriptTest() {
        PythonRequest pythonRequest = new PythonRequest("kMeansModel.py");

        pythonRequest.addArgumentWithName("dataset", "iris")
                .addArgumentWithName("test_size", 0.1);

        PythonBusiness pythonBusiness = new PythonBusiness();
        System.out.println(pythonRequest.toString());
        pythonBusiness.startProcessCall(pythonRequest);
        System.out.println(pythonBusiness.getJsonObjectResult().toString());
    }
}
