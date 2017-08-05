package com.hydramaze.hydramazerest.model.algorithmModel.svm;

import java.util.ArrayList;

public class SvmModel {
    private String name = "Support Vector Machine Classifier";
    private String importSource = "sklearn.svm";
    private String importName = "SVC";
    private String variableName = "svc";
    private String scriptName = "svmModel.py";
    private SvmParameters svmParameters = null;

    public SvmModel(SvmParameters svmParameters) {
        this.svmParameters = svmParameters;
    }

    public String buildImport() {
        return ("from " + importSource + " import " + importName);
    }

    public String buildVariable() {
        return (variableName + " = " +  importName + "(" + svmParameters.concatenateValues() + ") "
        );
    }
    public String[] buildScriptCall(){
        String call =  "python "+ scriptName +" " + svmParameters.concatenateCallValues();
        return call.split(" ");
    }


    public ArrayList<String> getPythonCodeLines(){
        return new ArrayList<String>(){{
           add(buildImport());
           add(buildVariable());
        }};
    }

}
