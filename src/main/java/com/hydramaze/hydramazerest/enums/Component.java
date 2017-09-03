package com.hydramaze.hydramazerest.enums;

public enum Component {

    COMBO_BOX("combo-box"),
    INPUT_NUMBER("input-number"),
    CHECK_BOX("check-box");

    public String componentName;

    Component(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentName() {
        return componentName;
    }
}
