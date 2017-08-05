package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
bool, default: False
Enable verbose output. Note that this setting takes advantage of a per-process runtime setting in libsvm that,
if enabled, may not work properly in a multithreaded context.
*/

//TODO confirmar necessidade

public class Verbose extends Parameter{
    public Verbose(boolean value) {
        if(value){
            setValue("True");
        }else{
            setValue("False");
        }
        setName("verbose");
    }
    public Verbose() {
        setValue("False");
        setName("verbose");
    }

}
