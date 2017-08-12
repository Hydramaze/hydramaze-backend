package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
float, optional
Specify the size of the kernel cache (in MB).
 */

//TODO confirmar valor default

public class CacheSize extends SvmParameter {
    public CacheSize() {
        super("200", "cache_size");
    }
    public CacheSize(float value) {
        super(String.valueOf(value), "cache_size");
    }
}
