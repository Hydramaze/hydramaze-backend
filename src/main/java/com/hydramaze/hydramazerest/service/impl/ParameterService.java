package com.hydramaze.hydramazerest.service.impl;

import com.hydramaze.hydramazerest.dao.IParameterDAO;
import com.hydramaze.hydramazerest.model.Parameter;
import com.hydramaze.hydramazerest.service.IParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mvg on 22/08/17.
 */
@Service
public class ParameterService implements IParameterService{

    @Autowired
    IParameterDAO parameterDAO;

    @Override
    public List<Parameter> getParametersByAlgorithmId(Integer id) {
        return parameterDAO.getParametersByAlgorithmId(id);
    }
}
