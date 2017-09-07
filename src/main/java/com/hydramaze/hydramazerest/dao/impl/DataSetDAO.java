package com.hydramaze.hydramazerest.dao.impl;

import com.hydramaze.hydramazerest.dao.IDataSetDAO;
import com.hydramaze.hydramazerest.model.DataSet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DataSetDAO implements IDataSetDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DataSet> getDataSetsByAlgorithmId(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT dataSetList ")
                .append("FROM Algorithm AS algorithm ")
                .append("LEFT JOIN algorithm.dataSetList AS dataSetList ")
                .append("WHERE algorithm.id = ").append(id);
        return (List<DataSet>) entityManager.createQuery(sql.toString()).getResultList();
    }
}
