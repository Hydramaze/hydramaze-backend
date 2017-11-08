package com.hydramaze.hydramazerest.dao;

import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.model.Exercise;

import java.util.List;

public interface IExerciseDAO {

    List<Algorithm> getAlgorithmsListWithExercise();

    List<Exercise> getExerciseListByAlgorithmId(Integer id);

}
