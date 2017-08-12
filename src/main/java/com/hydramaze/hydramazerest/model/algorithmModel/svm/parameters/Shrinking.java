package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
boolean, optional (default=True)
Whether to use the shrinking heuristic.
 */

public class Shrinking extends SvmParameter {

    public Shrinking() {
        super("True", "shrinking");
    }

    public Shrinking(boolean value) {
        super(value ? "True" : "False", "shrinking");
    }
}
