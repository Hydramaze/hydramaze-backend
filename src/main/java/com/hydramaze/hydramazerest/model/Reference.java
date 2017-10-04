package com.hydramaze.hydramazerest.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by mvg on 03/10/17.
 */

@Entity
@Table(name = "reference")
public class Reference {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @NotNull
    private String type;

    @NotBlank
    @NotNull
    private String url;

    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
