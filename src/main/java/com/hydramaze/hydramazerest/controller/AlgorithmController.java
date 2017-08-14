package com.hydramaze.hydramazerest.controller;

import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.service.IAlgorithmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/algorithm")
public class AlgorithmController {

    private static final Logger LOG = LoggerFactory.getLogger(AlgorithmController.class);

    @Autowired
    private IAlgorithmService algorithmService;

    private String getApiName() {
        return "algorithm";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAlgorithm() {
        try{
            List<Algorithm> response = algorithmService.getAllAlgorithm();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
