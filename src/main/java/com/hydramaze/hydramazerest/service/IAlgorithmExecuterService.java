package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.pojo.ParameterPojo;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public interface IAlgorithmExecuterService {

    JSONObject executeScript(Integer algorithmId, Integer dataSetId, Double learningCurve, List<ParameterPojo> pojo) throws Exception;

    InputStream downloadScript(Integer algorithmId, Integer dataSetId, Double learningCurve, List<ParameterPojo> pojo) throws Exception;

}
