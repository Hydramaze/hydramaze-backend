package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
int, optional (default=3)
Degree of the polynomial kernel function (‘poly’). Ignored by all other kernels.
 */

public class Degree extends SvmParameter {
    public Degree() {
        super("1.0", "degree");
    }
    public Degree(int value){
        super(String.valueOf(value), "degree");
    }
}
