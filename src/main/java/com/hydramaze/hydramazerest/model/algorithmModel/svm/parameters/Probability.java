package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
boolean, optional (default=False)
Whether to enable probability estimates.
This must be enabled prior to calling fit, and will slow down that method.
 */

public class Probability extends Parameter{
    public Probability() {
        setValue("False");
        setName("probability");
    }
    public Probability(boolean value){
        if(value){
            setValue("True");
        }else{
            setValue("False");
        }
        setName("probability");
    }
}
