package com.hydramaze.hydramazerest.controller;

import com.hydramaze.hydramazerest.model.Parameter;
import com.hydramaze.hydramazerest.service.IParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parameter")
public class ParameterController {

    private static final Logger LOG = LoggerFactory.getLogger(ParameterController.class);

    @Autowired
    private IParameterService parameterService;

    private String getApiName() {
        return "parameter";
    }

    @RequestMapping(value = "getByAlgorithmId", method = RequestMethod.GET)
    public ResponseEntity getParametersByAlgorithmId(@RequestParam (required = true) Integer id) {
        try{
            List<Parameter> response = parameterService.getParametersByAlgorithmId(id);

            if (response == null || response.isEmpty() || response.get(0) == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
