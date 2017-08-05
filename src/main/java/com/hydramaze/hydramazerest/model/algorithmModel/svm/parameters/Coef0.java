package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
float, optional (default=0.0)
Independent term in kernel function. It is only significant in ‘poly’ and ‘sigmoid’.
 */
public class Coef0 extends Parameter{
    public Coef0() {
        setValue("0.0");
        setName("coef0");
    }
    public Coef0(String value){
        setValue(value);
        setName("coef0");
    }
}
