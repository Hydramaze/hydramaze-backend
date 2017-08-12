package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
float, optional (default=1e-3)
Tolerance for stopping criterion.
 */
public class Tol extends SvmParameter {
    public Tol() {
        super("0.001", "tol");
    }
    public Tol(float value){
        super(String.valueOf(value), "tol");
    }

}
