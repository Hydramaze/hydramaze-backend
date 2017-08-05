package com.hydramaze.hydramazerest.model.algorithmModel.svm;

import com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters.*;

import java.util.ArrayList;

public class SvmParameters {
    private C c = new C();
    private CacheSize cacheSize = new CacheSize();
    private ClassWeight classWeight = new ClassWeight();
    private Coef0 coef0 = new Coef0();
    private DecisionFunctionShape decisionFunctionShape = new DecisionFunctionShape();
    private Degree degree = new Degree();
    private Gamma gamma = new Gamma();
    private Kernel kernel = new Kernel();
    private MaxIter maxIter = new MaxIter();
    private Probability probability = new Probability();
    private RandomState randomState = new RandomState();
    private Shrinking shrinking = new Shrinking();
    private Tol tol = new Tol();
    private Verbose verbose = new Verbose();
    private ArrayList<Parameter> allParameters;

    public String concatenateValues(){
        StringBuilder concatenatedString= new StringBuilder();
        for(Parameter p : getAllParameters()){
            concatenatedString.append(p.getCompleteArgument() + ", ");
        }
        return concatenatedString.toString().substring(0, concatenatedString.toString().length()-2);
    }

    public String concatenateCallValues(){
        StringBuilder concatenatedString= new StringBuilder();
        for(Parameter p : getAllParameters()){
            concatenatedString.append(p.getValue() + " ");
        }
        return concatenatedString.toString();
    }

    private SvmParameters(SvcPropertiesBuilder builder){
        this.c = builder.c;
        this.cacheSize = builder.cacheSize;
        this.classWeight = builder.classWeight;
        this.coef0 = builder.coef0;
        this.decisionFunctionShape = builder.decisionFunctionShape;
        this.degree = builder.degree;
        this.gamma = builder.gamma;
        this.kernel = builder.kernel;
        this.maxIter = builder.maxIter;
        this.probability = builder.probability;
        this.randomState = builder.randomState;
        this.shrinking = builder.shrinking;
        this.tol = builder.tol;
        this.verbose = builder.verbose;
    }

    public static class SvcPropertiesBuilder{
        private C c = new C();
        private CacheSize cacheSize = new CacheSize();
        private ClassWeight classWeight = new ClassWeight();
        private Coef0 coef0 = new Coef0();
        private DecisionFunctionShape decisionFunctionShape = new DecisionFunctionShape();
        private Degree degree = new Degree();
        private Gamma gamma = new Gamma();
        private Kernel kernel = new Kernel();
        private MaxIter maxIter = new MaxIter();
        private Probability probability = new Probability();
        private RandomState randomState = new RandomState();
        private Shrinking shrinking = new Shrinking();
        private Tol tol = new Tol();
        private Verbose verbose = new Verbose();


        public SvcPropertiesBuilder withC(C c){
            this.c = c;
            return this;
        }

        public SvcPropertiesBuilder withCacheSize(CacheSize cacheSize){
            this.cacheSize = cacheSize;
            return this;
        }
        public SvcPropertiesBuilder withClassWeight(ClassWeight classWeight){
            this.classWeight = classWeight;
            return this;
        }
        public SvcPropertiesBuilder withCoef0(Coef0 coef0){
            this.coef0 = coef0;
            return this;
        }
        public SvcPropertiesBuilder withDecisionFunctionShape(DecisionFunctionShape decisionFunctionShape){
            this.decisionFunctionShape = decisionFunctionShape;
            return this;
        }
        public SvcPropertiesBuilder withDegree(Degree degree){
            this.degree = degree;
            return this;
        }
        public SvcPropertiesBuilder withGamma(Gamma gamma){
            this.gamma = gamma;
            return this;
        }
        public SvcPropertiesBuilder withKernel(Kernel kernel){
            this.kernel = kernel;
            return this;
        }
        public SvcPropertiesBuilder withMaxIter (MaxIter maxIter){
            this.maxIter = maxIter;
            return this;
        }
        public SvcPropertiesBuilder withProbability(Probability probability){
            this.probability = probability;
            return this;
        }

        public SvcPropertiesBuilder withRandomState(RandomState randomState){
            this.randomState = randomState;
            return this;
        }

        public SvcPropertiesBuilder withShrinking(Shrinking shrinking){
            this.shrinking = shrinking;
            return this;
        }

        public SvcPropertiesBuilder withTol(Tol tol){
            this.tol = tol;
            return this;
        }

        public SvcPropertiesBuilder withVerbose(Verbose verbose){
            this.verbose = verbose;
            return this;
        }

        public SvmParameters build(){
            return new SvmParameters(this);
        }
    }

    private ArrayList<Parameter> getAllParameters(){
       return this.allParameters = new ArrayList<Parameter>(){{








           add(c);
            add(cacheSize);
            add(classWeight);
            add(coef0);
            add(decisionFunctionShape);
            add(degree);
            add(gamma);
            add(kernel);
            add(maxIter);
            add(probability);
            add(randomState);
            add(shrinking);
            add(tol);
            add(verbose);
        }};

    }

}
