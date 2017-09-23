package com.hydramaze.hydramazerest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;

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

    @NotBlank
    @NotNull
    private String scriptName;

    @NotBlank
    @NotNull
    private String templateName;

    @JsonIgnore
    @ElementCollection
    private List<Parameter> parameterList;

    @JsonIgnore
    @ElementCollection
    private List<DataSet> dataSetList;

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

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public List<DataSet> getDataSetList() {
        return dataSetList;
    }

    public void setDataSetList(List<DataSet> dataSetList) {
        this.dataSetList = dataSetList;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
