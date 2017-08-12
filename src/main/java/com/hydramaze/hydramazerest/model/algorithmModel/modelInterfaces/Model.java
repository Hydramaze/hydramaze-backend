package com.hydramaze.hydramazerest.model.algorithmModel.modelInterfaces;

import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmParameters;

import java.util.ArrayList;

public interface Model {
    String buildImport();

    String buildVariable();

    String[] buildScriptCall();

    ArrayList<String> getPythonCodeLines();


}
