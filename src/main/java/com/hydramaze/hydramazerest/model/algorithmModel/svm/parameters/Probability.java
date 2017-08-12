package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
boolean, optional (default=False)
Whether to enable probability estimates.
This must be enabled prior to calling fit, and will slow down that method.
 */

public class Probability extends SvmParameter {
    public Probability() {
        super("False", "probability");
    }
    public Probability(boolean value){
        super(value ? "True" : "False", "probability");
    }
}
