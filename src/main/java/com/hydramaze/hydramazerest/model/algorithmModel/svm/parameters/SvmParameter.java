package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

import com.hydramaze.hydramazerest.model.algorithmModel.modelInterfaces.Parameter;

public abstract class SvmParameter implements Parameter {
    protected String value;
    protected String name;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCompleteArgument(){
        return (name + "=" +value);
    }

    public SvmParameter(String value, String name){
        this.value = value;
        this.name = name;
    }
}
