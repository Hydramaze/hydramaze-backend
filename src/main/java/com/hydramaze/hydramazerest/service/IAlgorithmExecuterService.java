package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.pojo.ParameterPojo;

import java.util.List;

public interface IAlgorithmExecuterService {

    void executeScript(Integer algorithmId, List<ParameterPojo> pojo) throws Exception;

}
