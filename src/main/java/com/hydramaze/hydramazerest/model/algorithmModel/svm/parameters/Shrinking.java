package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
boolean, optional (default=True)
Whether to use the shrinking heuristic.
 */

public class Shrinking extends Parameter{
    public Shrinking(boolean value) {
        if(value){
            setValue("True");
        }else{
            setValue("False");
        }
        setName("shrinking");
    }

    public Shrinking() {
        setValue("True");
        setName("shrinking");
    }
}
