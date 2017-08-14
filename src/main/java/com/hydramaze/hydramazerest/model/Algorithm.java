package com.hydramaze.hydramazerest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mvg on 13/08/17.
 */

@Entity
@Table(name = "algorithm")
public class Algorithm {
    @Id
    private String name;
    private String simpleDescription;
    private String completeDescription;

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
}
