package com.hydramaze.hydramazerest.model.algorithmModel.modelInterfaces;

import com.hydramaze.hydramazerest.model.algorithmModel.svm.SvmParameters;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters.*;

import java.util.ArrayList;

public interface ModelParameters {

    String concatenateValues();

    String concatenateCallValues();

    ArrayList<Parameter> getParameters();

}
