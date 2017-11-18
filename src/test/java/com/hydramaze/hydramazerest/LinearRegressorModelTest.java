package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinearRegressorModelTest {

    @Test
    public void callScriptTest() {
        ArrayList<String> datasets = new ArrayList<String>() {{
            add("boston");
            add("diabetes");
        }};

        ArrayList<Float> testSizes = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            testSizes.add(i / 10f);
        }
        ArrayList<Boolean> normalizes = new ArrayList<Boolean>() {{
            add(true);
            add(false);
        }};
        ArrayList<Boolean> fits = new ArrayList<Boolean>() {{
            add(true);
            add(false);
        }};
        ArrayList<Integer> nJobs = new ArrayList<>();
        for (int i = -1; i < 10; i++) {
            if (i != 0)
                nJobs.add(i);
        }

        nJobs.parallelStream().forEach((n_jobs) -> {
            datasets.parallelStream().forEach((dataset) -> {
                for (boolean normalize : normalizes) {
                    for (boolean fit : fits) {
                        for (float test_size : testSizes) {
                            PythonRequest pythonRequest = new PythonRequest("linearRegressorModel.py");

                            pythonRequest.addArgumentWithName("dataset", dataset)
                                    .addArgumentWithName("test_size", test_size)
                                    .addArgumentWithName("fit_intercept", fit)
                                    .addArgumentWithName("normalize", normalize)
                                    .addArgumentWithName("n_jobs", n_jobs);
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
