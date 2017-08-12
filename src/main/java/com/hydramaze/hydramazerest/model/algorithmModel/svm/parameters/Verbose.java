package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
bool, default: False
Enable verbose output. Note that this setting takes advantage of a per-process runtime setting in libsvm that,
if enabled, may not work properly in a multithreaded context.
*/

//TODO confirmar necessidade

public class Verbose extends SvmParameter {

    public Verbose() {
        super("False", "verbose");
    }

    public Verbose(boolean value) {
        super(value ? "True" : "False", "verbose");
    }
}
