package com.hydramaze.hydramazerest.service.impl;

import com.hydramaze.hydramazerest.dao.IExerciseDAO;
import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.model.Exercise;
import com.hydramaze.hydramazerest.service.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService implements IExerciseService {

    @Autowired
    private IExerciseDAO exerciseDAO;

    @Override
    public List<Algorithm> getAlgorithmsListWithExercise() {
        return exerciseDAO.getAlgorithmsListWithExercise();
    }

    @Override
    public List<Exercise> getExerciseListByAlgorithmId(Integer id) {
        return exerciseDAO.getExerciseListByAlgorithmId(id);
    }

}
