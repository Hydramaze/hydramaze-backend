package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
int, optional (default=-1)
Hard limit on iterations within solver, or -1 for no limit.
 */

public class MaxIter extends Parameter{
    public MaxIter() {
        setValue("-1");
        setName("max_iter");
    }
    public MaxIter(int value){
        setValue(String.valueOf(value));
        setName("max_iter");
    }
}
