package com.hydramaze.hydramazerest.dao.impl;

import com.hydramaze.hydramazerest.dao.IAlgorithmDAO;
import com.hydramaze.hydramazerest.model.Algorithm;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mvg on 13/08/17.
 */

@Repository
public class AlgorithmDAO implements IAlgorithmDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Algorithm> getAll() {
        String hql = "FROM Algorithm AS a ORDER BY a.name";
        return (List<Algorithm>) entityManager.createQuery(hql).getResultList();
    }
}
