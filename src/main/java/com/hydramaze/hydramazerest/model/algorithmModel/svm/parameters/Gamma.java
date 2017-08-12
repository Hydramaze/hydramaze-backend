package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
 float, optional (default=’auto’)
Kernel coefficient for ‘rbf’, ‘poly’ and ‘sigmoid’.
If gamma is ‘auto’ then 1/n_features will be used instead.
 */

//TODO conferir range de valores aceitáveis

public class Gamma extends SvmParameter {
    public Gamma() {
        super("auto", "gamma");
    }
    public Gamma(float value) {
        super(String.valueOf(value), "gamma");
    }

}
