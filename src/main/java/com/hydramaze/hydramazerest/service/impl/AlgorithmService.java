package com.hydramaze.hydramazerest.service.impl;

import com.hydramaze.hydramazerest.dao.IAlgorithmDAO;
import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.service.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mvg on 13/08/17.
 */
@Service
public class AlgorithmService implements IAlgorithmService {

    @Autowired
    private IAlgorithmDAO algorithmDAO;

    @Override
    public List<Algorithm> getAllAlgorithm() {
        return algorithmDAO.getAll();
    }
}
