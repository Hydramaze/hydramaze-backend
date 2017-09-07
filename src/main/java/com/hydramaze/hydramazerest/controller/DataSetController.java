package com.hydramaze.hydramazerest.controller;

import com.hydramaze.hydramazerest.model.DataSet;
import com.hydramaze.hydramazerest.service.IDataSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-set")
public class DataSetController {

    private static final Logger LOG = LoggerFactory.getLogger(DataSetController.class);

    @Autowired
    private IDataSetService dataSetService;

    private String getApiName() {
        return "data-set";
    }

    @RequestMapping(value = "getByAlgorithmId", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getDataSetListByAlgorithmId(@RequestParam(required = true) Integer id) {
        try{
            List<DataSet> response = dataSetService.getDataSetsByAlgorithmId(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
