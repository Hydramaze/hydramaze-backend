package com.hydramaze.hydramazerest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by mvg on 13/08/17.
 */

@Entity
@Table(name = "data_set")
public class DataSet {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String simpleDescription;

    @NotBlank
    @NotNull
    private String completeDescription;

    @JsonIgnore
    @NotBlank
    @NotNull
    private String pythonDataSetName;

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

    public String getPythonDataSetName() {
        return pythonDataSetName;
    }

    public void setPythonDataSetName(String pythonDataSetName) {
        this.pythonDataSetName = pythonDataSetName;
    }
}
