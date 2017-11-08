package com.hydramaze.hydramazerest.dao.impl;

import com.hydramaze.hydramazerest.dao.IExerciseDAO;
import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.model.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ExerciseDAO implements IExerciseDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Algorithm> getAlgorithmsListWithExercise() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT algorithm ")
                .append("FROM Exercise");
        return (List<Algorithm>) entityManager.createQuery(sql.toString()).getResultList();
    }

    @Override
    public List<Exercise> getExerciseListByAlgorithmId(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("FROM Exercise AS exercise ")
                .append("WHERE exercise.algorithm = ").append(id);
        return (List<Exercise>) entityManager.createQuery(sql.toString()).getResultList();
    }
}
