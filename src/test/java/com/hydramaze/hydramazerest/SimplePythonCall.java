package com.hydramaze.hydramazerest;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import org.junit.Test;

public class SimplePythonCall {

    @Test
    public void callScriptTest() {

        String[] call = new String[4];

        call[0] = "python";
        call[1] = "pocArgumentsClassifier.py";
        call[2] = "rbf";
        call[3] = "true";

        PythonBusiness pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcess(call);
    }

}
