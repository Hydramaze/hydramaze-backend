package com.hydramaze.hydramazerest.service;

import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.model.Exercise;

import java.util.List;

public interface IExerciseService {

    List<Algorithm> getAlgorithmsListWithExercise();

    List<Exercise> getExerciseListByAlgorithmId(Integer id);
}
