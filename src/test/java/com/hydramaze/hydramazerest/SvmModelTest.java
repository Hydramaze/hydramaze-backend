package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmModel;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmParameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Handler;

public class SvmModelTest {

    @Test
    public void callScriptTest() {
        ArrayList<Float> testSizes = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            testSizes.add(i / 10f);
        }
        ArrayList<Float> cs = new ArrayList<>();
        for (float i = 0.0001f; i <= 1000000; i = i * 10) {
            cs.add(i);
        }
        ArrayList<String> datasets = new ArrayList<String>() {{
            add("iris");
            add("breast_cancer");
            add("digits");
        }};
        ArrayList<Float> gammas = new ArrayList<>();
        for (float i = 0.0001f; i <= 1000000; i = i * 10) {
            gammas.add(i);
        }
        ArrayList<String> kernels = new ArrayList<String>() {{
            add("sigmoid");
            add("rbf");
            add("linear");
            add("poly");
        }};

        datasets.parallelStream().forEach((dataset) -> {
            kernels.parallelStream().forEach((kernel) -> {
                for (float gamma : gammas) {
                    for (float c : cs) {
                        for (float test_size : testSizes) {
                            PythonRequest pythonRequest = new PythonRequest("svmModel.py");
                            pythonRequest.addArgumentWithName("dataset", dataset)
                                    .addArgumentWithName("test_size", test_size)
                                    .addArgumentWithName("kernel", kernel)
                                    .addArgumentWithName("verbose", false)
                                    .addArgumentWithName("C", c)
                                    .addArgumentWithName("cache_size", 200)
                                    .addArgumentWithName("coef0", 0f)
                                    .addArgumentWithName("degree", 3)
                                    .addArgumentWithName("gamma", gamma)
                                    .addArgumentWithName("max_iter", -1)
                                    .addArgumentWithName("probability", false)
                                    .addArgumentWithName("shrinking", false)
                                    .addArgumentWithName("tol", 0.001);
                            PythonBusiness pythonBusiness = new PythonBusiness();
                            pythonBusiness.startProcessCall(pythonRequest);
                            if (pythonBusiness.getJsonObjectResult() == null) {
                                System.out.println("test failed, return null");
                                System.out.println(pythonRequest.toString());
                            } else if (pythonBusiness.getJsonObjectResult().toString().contains("error")) {
                                System.out.println("test failed, python error");
                                System.out.println(pythonRequest.toString());
                            }
                        }
                    }
                }
            });
        });
    }
}


