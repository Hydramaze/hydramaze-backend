package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.model.DataSet;

import java.util.List;

public interface IDataSetService {

    List<DataSet> getDataSetsByAlgorithmId(Integer id);

}
