package com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters;
/*
‘ovo’, ‘ovr’ or None, default=None
Whether to return a one-vs-rest (‘ovr’) decision function of shape (n_samples, n_classes) as all other classifiers,
or the original one-vs-one (‘ovo’) decision function of libsvm which has shape (n_samples, n_classes * (n_classes - 1) / 2).
The default of None will currently behave as ‘ovo’ for backward compatibility and raise a deprecation warning, but will change ‘ovr’ in 0.19.
New in version 0.17: decision_function_shape=’ovr’ is recommended.
Changed in version 0.17: Deprecated decision_function_shape=’ovo’ and None.
 */

public class DecisionFunctionShape extends Parameter{

    public DecisionFunctionShape(){
        setValue("None");
        setName("decision_function_shape");
    }

    public DecisionFunctionShape(DecisionFunctionShapeType decisionFunctionShapeType){
        setValue(decisionFunctionShapeType.getValue());
        setName("decision_function_shape");
    }



    public enum DecisionFunctionShapeType{
        OVO,
        OVR,
        NONE;

        String getValue(){
            switch(this){
                case OVO:
                    return "ovo";
                case OVR:
                    return "ovr";
                case NONE:
                    return "None";
                default:
                    return "None";
            }
        }
    }
}
