package com.hydramaze.hydramazerest.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @NotNull
    @OneToOne
    private Algorithm algorithm;

    @NotBlank
    @NotNull
    private String exerciseNumber;

    @NotBlank
    @NotNull
    private String problemIntroduction;

    @NotBlank
    @NotNull
    private String preExerciseCode;

    @NotBlank
    @NotNull
    private String sampleCode;

    @NotBlank
    @NotNull
    private String solution;

    @NotBlank
    @NotNull
    private String validation;

    private String hint;

    @ManyToMany
    private List<Reference> references;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getExerciseNumber() {
        return exerciseNumber;
    }

    public void setExerciseNumber(String exerciseNumber) {
        this.exerciseNumber = exerciseNumber;
    }

    public String getProblemIntroduction() {
        return problemIntroduction;
    }

    public void setProblemIntroduction(String problemIntroduction) {
        this.problemIntroduction = problemIntroduction;
    }

    public String getPreExerciseCode() {
        return preExerciseCode;
    }

    public void setPreExerciseCode(String preExerciseCode) {
        this.preExerciseCode = preExerciseCode;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }
}
