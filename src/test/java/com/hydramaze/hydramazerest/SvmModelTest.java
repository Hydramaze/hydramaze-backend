package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmModel;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmParameters;
import org.junit.Test;

public class SvmModelTest {

    @Test
    public void callScriptTest() {
        PythonRequest pythonRequest = new PythonRequest("svmModel.py");

        pythonRequest.addArgumentWithName("dataset", "iris")
                .addArgumentWithName("test_size", 0.5)
                .addArgumentWithName("kernel", "rbf")
                .addArgumentWithName("verbose", false)
                .addArgumentWithName("C", 1)
                .addArgumentWithName("cache_size", 200)
                .addArgumentWithName("coef0", 0f)
                .addArgumentWithName("degree", 3)
                .addArgumentWithName("gamma", "auto")
                .addArgumentWithName("max_iter", -1)
                .addArgumentWithName("probability", false)
                .addArgumentWithName("shrinking", false)
                .addArgumentWithName("tol", 0.001);


        PythonBusiness pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcessCall(pythonRequest);
        System.out.println(pythonRequest.toString());
        System.out.println(pythonBusiness.getJsonObjectResult().toString());
    }
}
