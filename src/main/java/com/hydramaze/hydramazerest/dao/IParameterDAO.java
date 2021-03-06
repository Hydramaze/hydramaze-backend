package com.hydramaze.hydramazerest.dao;

import com.hydramaze.hydramazerest.model.Parameter;

import java.util.List;

/**
 * Created by mvg on 22/08/17.
 */
public interface IParameterDAO {

    Parameter getById(Integer id);

    List<Parameter> getParametersByAlgorithmId(Integer id);
}
