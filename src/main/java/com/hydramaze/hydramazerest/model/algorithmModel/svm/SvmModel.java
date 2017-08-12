package com.hydramaze.hydramazerest.model.algorithmModel.svm;

import com.hydramaze.hydramazerest.model.algorithmModel.modelInterfaces.Model;

import java.util.ArrayList;

public class SvmModel implements Model{
    private String name = "Support Vector Machine Classifier";
    private String importSource = "sklearn.svm";
    private String importName = "SVC";
    private String variableName = "svc";
    private String scriptName = "svmModel.py";
    private SvmParameters svmParameters = null;

    public SvmModel(SvmParameters svmParameters) {
        this.svmParameters = svmParameters;
    }

    @Override
    public String buildImport() {
        return ("from " + importSource + " import " + importName);
    }

    @Override
    public String buildVariable() {
        return (variableName + " = " +  importName + "(" + svmParameters.concatenateValues() + ") "
        );
    }

    @Override
    public String[] buildScriptCall(){
        String call =  "python "+ scriptName +" " + svmParameters.concatenateCallValues();
        return call.split(" ");
    }

    @Override
    public ArrayList<String> getPythonCodeLines(){
        return new ArrayList<String>(){{
           add(buildImport());
           add(buildVariable());
        }};
    }

}
