package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.pojo.ParameterPojo;
import org.json.JSONObject;

import java.util.List;

public interface IAlgorithmExecuterService {

    JSONObject executeScript(Integer algorithmId, List<ParameterPojo> pojo) throws Exception;

}
