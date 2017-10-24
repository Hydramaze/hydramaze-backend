package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.PythonRequest;
import org.junit.Test;

public class KMeansModelTest {

    @Test
    public void callScriptTest() {
        PythonRequest pythonRequest = new PythonRequest("kMeansModel.py");

        pythonRequest.addArgumentWithName("dataset", "diabetes")
                .addArgumentWithName("test_size", 0.1)
                .addArgumentWithName("n_clusters", 2)
                .addArgumentWithName("init", "k-means++")
                .addArgumentWithName("n_init", 1)
                .addArgumentWithName("max_iter", 100)
                .addArgumentWithName("tol", 0.0001)
                .addArgumentWithName("precompute_distances", "auto")
                .addArgumentWithName("verbose", 3)
                .addArgumentWithName("copy_x", "auto")
                .addArgumentWithName("n_jobs", 4)
                .addArgumentWithName("algorithm", "auto");

        PythonBusiness pythonBusiness = new PythonBusiness();
        System.out.println(pythonRequest.toString());
        pythonBusiness.startProcessCall(pythonRequest);
        System.out.println(pythonBusiness.getJsonObjectResult().toString());
    }
}
