package com.hydramaze.hydramazerest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mvg on 13/08/17.
 */

@Entity
@Table(name = "data_set")
public class DataSet {
    @Id
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
