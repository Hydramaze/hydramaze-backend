package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
float, optional (default=0.0)
Independent term in kernel function. It is only significant in ‘poly’ and ‘sigmoid’.
 */
public class Coef0 extends SvmParameter {
    public Coef0() {
        super("0.0", "coef0");
    }
    public Coef0(float value){
        super(String.valueOf(value), "coef0");
    }
}
