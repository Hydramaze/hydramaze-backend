package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.model.Algorithm;

import java.util.List;

/**
 * Created by mvg on 13/08/17.
 */
public interface IAlgorithmService {

    Algorithm getAlgorithmById(Integer id);

    List<Algorithm> getAllAlgorithm();
}
