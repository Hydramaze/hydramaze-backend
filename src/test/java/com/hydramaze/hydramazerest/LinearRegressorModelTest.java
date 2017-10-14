package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

import java.util.List;

public class LinearRegressorModelTest {

    @Test
    public void callScriptTest() {
        PythonRequest pythonRequest = new PythonRequest("linearRegressorModel.py");

        pythonRequest.addArgumentWithName("dataset", "diabetes")
                .addArgumentWithName("test_size", 0.1)
                .addArgumentWithName("fit_intercept", true)
                .addArgumentWithName("normalize", true)
                .addArgumentWithName("n_jobs", -1);


        System.out.println(pythonRequest.toString());
        PythonBusiness pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcessCall(pythonRequest);
        System.out.println(pythonBusiness.getJsonObjectResult().toString());
    }
}
