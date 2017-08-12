package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
int, optional (default=-1)
Hard limit on iterations within solver, or -1 for no limit.
 */

public class MaxIter extends SvmParameter {
    public MaxIter() {
        super("-1", "max_iter");
    }
    public MaxIter(int value){
        super(String.valueOf(value), "max_iter");
    }
}
