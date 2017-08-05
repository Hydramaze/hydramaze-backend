package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

public abstract class Parameter {
    protected String value;
    protected String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompleteArgument(){
        return (name + "="+value);
    }
}
