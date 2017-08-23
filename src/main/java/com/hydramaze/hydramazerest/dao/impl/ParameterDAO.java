package com.hydramaze.hydramazerest.dao.impl;

import com.hydramaze.hydramazerest.dao.IParameterDAO;
import com.hydramaze.hydramazerest.model.Parameter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mvg on 22/08/17.
 */
@Repository
public class ParameterDAO implements IParameterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Parameter> getParametersByAlgorithmId(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT parameterList ")
                .append("FROM Algorithm AS algorithm ")
                .append("LEFT JOIN algorithm.parameterList AS parameterList ")
                .append("WHERE algorithm.id = ").append(id);
        return (List<Parameter>) entityManager.createQuery(sql.toString()).getResultList();
    }
}
