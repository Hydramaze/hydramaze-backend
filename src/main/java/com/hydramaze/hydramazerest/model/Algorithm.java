package com.hydramaze.hydramazerest.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by mvg on 13/08/17.
 */

@Entity
@Table(name = "algorithm")
public class Algorithm {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String type;

    @NotBlank
    @NotNull
    private String learningType;

    @NotBlank
    @NotNull
    private String simpleDescription;

    @NotBlank
    @NotNull
    private String completeDescription;

    @ElementCollection
    private List<Parameter> parameterList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLearningType() {
        return learningType;
    }

    public void setLearningType(String learningType) {
        this.learningType = learningType;
    }

    public String getSimpleDescription() {
        return simpleDescription;
    }

    public void setSimpleDescription(String simpleDescription) {
        this.simpleDescription = simpleDescription;
    }

    public String getCompleteDescription() {
        return completeDescription;
    }

    public void setCompleteDescription(String completeDescription) {
        this.completeDescription = completeDescription;
    }

//    public List<Parameter> getParameterList() {
//        return parameterList;
//    }
//
//    public void setParameterList(List<Parameter> parameterList) {
//        this.parameterList = parameterList;
//    }
}
