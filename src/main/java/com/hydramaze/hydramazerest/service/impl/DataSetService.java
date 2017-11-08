package com.hydramaze.hydramazerest.service.impl;

import com.hydramaze.hydramazerest.dao.IDataSetDAO;
import com.hydramaze.hydramazerest.model.DataSet;
import com.hydramaze.hydramazerest.service.IDataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSetService implements IDataSetService {

    @Autowired
    private IDataSetDAO dataSetDAO;

    @Override
    public List<DataSet> getDataSetsByAlgorithmId(Integer id) {
        return dataSetDAO.getDataSetsByAlgorithmId(id);
    }
}
