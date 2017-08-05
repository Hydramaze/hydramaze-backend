package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
float, optional (default=1.0)
Penalty parameter C of the error term
*/

public class C extends Parameter {
    public C(){
        setValue("1.0");
        setName("C");
    }
    public C (String value){
        setValue(value);
        setName("C");
    }
}
