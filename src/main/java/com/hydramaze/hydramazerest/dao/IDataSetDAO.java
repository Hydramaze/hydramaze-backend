package com.hydramaze.hydramazerest.dao;

import com.hydramaze.hydramazerest.model.DataSet;

import java.util.List;

public interface IDataSetDAO {

    List<DataSet> getDataSetsByAlgorithmId(Integer id);

}
