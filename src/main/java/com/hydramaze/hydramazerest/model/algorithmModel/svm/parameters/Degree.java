package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
int, optional (default=3)
Degree of the polynomial kernel function (‘poly’). Ignored by all other kernels.
 */

public class Degree extends Parameter{
    public Degree() {
        setValue("3");
    }
    public Degree(int value){
        setValue(String.valueOf(value));
    }
}
