package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.model.Parameter;

import java.util.List;

/**
 * Created by mvg on 22/08/17.
 */
public interface IParameterService {

    List<Parameter> getParametersByAlgorithmId(Integer id);
}
