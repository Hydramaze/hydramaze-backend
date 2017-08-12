package com.hydramaze.hydramazerest.model.algorithmModel.svm;

import com.hydramaze.hydramazerest.model.algorithmModel.modelInterfaces.ModelParameters;
import com.hydramaze.hydramazerest.model.algorithmModel.modelInterfaces.Parameter;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters.SvmParameter;
import com.hydramaze.hydramazerest.model.algorithmModel.svm.parameters.*;

import java.util.ArrayList;

public class SvmParameters implements ModelParameters {
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
    private ArrayList<Parameter> allSvmParameters;

    public String concatenateValues(){
        StringBuilder concatenatedString= new StringBuilder();
        for(Parameter p : getParameters()){
            concatenatedString.append(p.getCompleteArgument());
            concatenatedString.append( ", ");
        }
        return concatenatedString.toString().substring(0, concatenatedString.toString().length()-2);
    }

    public String concatenateCallValues(){
        StringBuilder concatenatedString= new StringBuilder();
        for(Parameter p : getParameters()){
            concatenatedString.append(p.getValue());
            concatenatedString.append(" ");
        }
        return concatenatedString.toString();
    }

    private SvmParameters(SvmPropertiesBuilder builder){
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

    public static class SvmPropertiesBuilder{
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


        public SvmPropertiesBuilder withC(C c){
            this.c = c;
            return this;
        }

        public SvmPropertiesBuilder withCacheSize(CacheSize cacheSize){
            this.cacheSize = cacheSize;
            return this;
        }
        public SvmPropertiesBuilder withClassWeight(ClassWeight classWeight){
            this.classWeight = classWeight;
            return this;
        }
        public SvmPropertiesBuilder withCoef0(Coef0 coef0){
            this.coef0 = coef0;
            return this;
        }
        public SvmPropertiesBuilder withDecisionFunctionShape(DecisionFunctionShape decisionFunctionShape){
            this.decisionFunctionShape = decisionFunctionShape;
            return this;
        }
        public SvmPropertiesBuilder withDegree(Degree degree){
            this.degree = degree;
            return this;
        }
        public SvmPropertiesBuilder withGamma(Gamma gamma){
            this.gamma = gamma;
            return this;
        }
        public SvmPropertiesBuilder withKernel(Kernel kernel){
            this.kernel = kernel;
            return this;
        }
        public SvmPropertiesBuilder withMaxIter (MaxIter maxIter){
            this.maxIter = maxIter;
            return this;
        }
        public SvmPropertiesBuilder withProbability(Probability probability){
            this.probability = probability;
            return this;
        }

        public SvmPropertiesBuilder withRandomState(RandomState randomState){
            this.randomState = randomState;
            return this;
        }

        public SvmPropertiesBuilder withShrinking(Shrinking shrinking){
            this.shrinking = shrinking;
            return this;
        }

        public SvmPropertiesBuilder withTol(Tol tol){
            this.tol = tol;
            return this;
        }

        public SvmPropertiesBuilder withVerbose(Verbose verbose){
            this.verbose = verbose;
            return this;
        }

        public SvmParameters build(){
            return new SvmParameters(this);
        }
    }

    @Override
    public ArrayList<Parameter> getParameters(){
       return this.allSvmParameters = new ArrayList<Parameter>(){{
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
