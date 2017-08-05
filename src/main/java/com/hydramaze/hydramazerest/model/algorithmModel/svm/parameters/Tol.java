package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
float, optional (default=1e-3)
Tolerance for stopping criterion.
 */
public class Tol extends Parameter{
    public Tol() {
        setValue("0.001");
        setName("tol");
    }
    public Tol(float value){
        setValue(String.valueOf(value));
        setName("tol");
    }

}
