package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;

/*
{dict, ‘balanced’}, optional
Set the parameter C of class i to class_weight[i]*C for SVC.
If not given, all classes are supposed to have weight one.
The “balanced” mode uses the values of y to automatically adjust weights
inversely proportional to class frequencies in the input data as n_samples / (n_classes * np.bincount(y))
 */

//TODO wtf

public class ClassWeight extends Parameter{
    public ClassWeight() {
        setName("class_weight");
        setValue("None");
    }
    public ClassWeight(int value) {
        setName("class_weight");
        setValue(String.valueOf(value));
    }

}
