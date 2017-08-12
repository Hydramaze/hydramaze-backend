package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
string, optional (default=’rbf’)
Specifies the kernel type to be used in the algorithm.
 It must be one of ‘linear’, ‘poly’, ‘rbf’, ‘sigmoid’, ‘precomputed’ or a callable.
 If none is given, ‘rbf’ will be used. If a callable is given it is used to pre-compute the kernel matrix from data matrices;
  that matrix should be an array of shape (n_samples, n_samples).
 */

public class Kernel extends SvmParameter {

    public Kernel() {
        super(KernelType.RBF.getValue(), "kernel");
    }

    public Kernel(KernelType kernelType) {
        super(kernelType.getValue(), "kernel");
    }

    public enum KernelType{
        LINEAR,
        POLY,
        RBF,
        SIGMOID,
        PRECOMPUTED;

        String getValue(){
            switch (this){
                case LINEAR:
                    return "linear";
                case POLY:
                    return "poly";
                case RBF:
                    return "rbf";
                case SIGMOID:
                    return "sigmoid";
                case PRECOMPUTED:
                    return "precomputed";
                default:
                    return "rbf";
            }
        }
    }
}
