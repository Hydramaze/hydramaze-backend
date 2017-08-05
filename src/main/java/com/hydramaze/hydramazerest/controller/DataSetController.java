package com.hydramaze.hydramazerest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data-set")
public class DataSetController {

    private static final Logger LOG = LoggerFactory.getLogger(DataSetController.class);

    private String getApiName() {
        return "data-set";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getDataSet() {
        try{
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
