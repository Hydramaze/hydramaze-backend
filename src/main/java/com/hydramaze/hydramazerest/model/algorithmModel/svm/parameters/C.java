package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
float, optional (default=1.0)
Penalty parameter C of the error term
*/

public class C extends SvmParameter {
    public C(){
        super("1.0", "C");
    }
    public C (float value){
        super(String.valueOf(value), "C");
    }
}
