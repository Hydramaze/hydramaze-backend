package com.hydramaze.hydramazerest.controller;

import com.hydramaze.hydramazerest.pojo.ParameterPojo;
import com.hydramaze.hydramazerest.service.IAlgorithmExecuterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/algorithmExecuter")
public class AlgorithmExecuterController {

    private static final Logger LOG = LoggerFactory.getLogger(AlgorithmExecuterController.class);

    @Autowired
    private IAlgorithmExecuterService algorithmExecuterService;

    private String getApiName() {
        return "algorithmExecuter";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity executeAlgorithm(@RequestParam(required = true) Integer algorithmId,
                                           @RequestParam(required = true) Integer dataSetId,
                                           @RequestParam(required = true) Double learningCurve,
                                           @RequestBody(required = true) List<ParameterPojo> pojo) {
        try{
            algorithmExecuterService.executeScript(algorithmId, dataSetId, learningCurve, pojo);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
