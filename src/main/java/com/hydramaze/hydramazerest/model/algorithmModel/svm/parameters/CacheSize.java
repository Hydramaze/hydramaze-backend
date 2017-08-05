package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
float, optional
Specify the size of the kernel cache (in MB).
 */

//TODO confirmar valor default

public class CacheSize extends Parameter{
    public CacheSize() {
        setValue("200");
        setName("cache_size");
    }
    public CacheSize(float value) {
        setValue(String.valueOf(value));
        setName("cache_size");
    }
}
