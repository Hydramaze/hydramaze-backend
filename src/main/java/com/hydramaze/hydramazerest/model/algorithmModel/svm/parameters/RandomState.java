package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
 int seed, RandomState instance, or None (default)
The seed of the pseudo random number generator to use when shuffling the data for probability estimation.
 */

//TODO confirmar range de valores aceitáveis

public class RandomState extends Parameter{
    public RandomState() {
        setValue("None");
        setName("random_state");
    }
    public RandomState(float value) {
        setValue(String.valueOf(value));
        setName("random_state");
    }
}
