package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

import java.util.ArrayList;

public class KMeansModelTest {

    @Test
    public void callScriptTest() {
        ArrayList<String> datasets = new ArrayList<String>() {{
            add("boston");
            add("diabetes");
            add("iris");
            add("breast_cancer");
            add("digits");
        }};
        ArrayList<String> inits = new ArrayList<String>() {{
            add("k-means++");
            add("random");
        }};
        ArrayList<String> copyXs = new ArrayList<String>() {{
            add("auto");
            add("true");
            add("false");
        }};
        ArrayList<String> precomputes = new ArrayList<String>() {{
            add("auto");
            add("true");
            add("false");
        }};
        ArrayList<String> algorithms = new ArrayList<String>() {{
            add("auto");
            add("full");
            add("elkan");
        }};

        ArrayList<Float> testSizes = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            testSizes.add(i / 10f);
        }

        ArrayList<Integer> nClusters = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            nClusters.add(i);
        }

        ArrayList<Integer> nInits = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            nInits.add(i);
        }
        algorithms.parallelStream().forEach((algoritm) -> {
            datasets.parallelStream().forEach((dataset) -> {
                for (String init : inits) {
                    for (int nInit : nInits) {
                        for (int nCluster : nClusters) {
                            for (float test_size : testSizes) {
                                for (String precompute : precomputes) {
                                    for (String copyX : copyXs) {

                                        PythonRequest pythonRequest = new PythonRequest("kMeansModel.py");

                                        pythonRequest.addArgumentWithName("dataset", dataset)
                                                .addArgumentWithName("test_size", test_size)
                                                .addArgumentWithName("n_clusters", nCluster)
                                                .addArgumentWithName("init", init)
                                                .addArgumentWithName("n_init", nInit)
                                                .addArgumentWithName("max_iter", 100)
                                                .addArgumentWithName("tol", 0.0001)
                                                .addArgumentWithName("precompute_distances", precompute)
                                                .addArgumentWithName("verbose", 3)
                                                .addArgumentWithName("copy_x", copyX)
                                                .addArgumentWithName("n_jobs", -1)
                                                .addArgumentWithName("algorithm", algoritm);
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
                        }
                    }
                }
            });
        });
    }
}
