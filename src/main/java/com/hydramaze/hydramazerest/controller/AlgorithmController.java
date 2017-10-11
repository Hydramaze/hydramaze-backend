package com.hydramaze.hydramazerest.controller;

import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.model.DataSet;
import com.hydramaze.hydramazerest.model.Parameter;
import com.hydramaze.hydramazerest.pojo.ParameterPojo;
import com.hydramaze.hydramazerest.service.IAlgorithmExecuterService;
import com.hydramaze.hydramazerest.service.IAlgorithmService;
import com.hydramaze.hydramazerest.service.IDataSetService;
import com.hydramaze.hydramazerest.service.IParameterService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/algorithm")
public class AlgorithmController {

    private static final Logger LOG = LoggerFactory.getLogger(AlgorithmController.class);

    @Autowired
    private IAlgorithmService algorithmService;

    @Autowired
    private IParameterService parameterService;

    @Autowired
    private IDataSetService dataSetService;

    @Autowired
    private IAlgorithmExecuterService algorithmExecuterService;

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

    @RequestMapping(value = "/{id}/parameter", method = RequestMethod.GET)
    public ResponseEntity getParametersByAlgorithmId(@PathVariable Integer id) {
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

    @RequestMapping(value = "/{id}/data-set", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getDataSetListByAlgorithmId(@PathVariable Integer id) {
        try{
            List<DataSet> response = dataSetService.getDataSetsByAlgorithmId(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}/execute", method = RequestMethod.POST)
    public ResponseEntity executeAlgorithm(@PathVariable Integer id,
                                           @RequestParam(required = true) Integer dataSetId,
                                           @RequestParam(required = true) Double testSize,
                                           @RequestBody(required = true) List<ParameterPojo> pojo) {
        try{
            JSONObject jsonObject = algorithmExecuterService.executeScript(id, dataSetId, testSize, pojo);
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[POST] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}/download", method = RequestMethod.POST)
    public ResponseEntity download(@PathVariable Integer id,
                                   @RequestParam(required = true) Integer dataSetId,
                                   @RequestParam(required = true) Double testSize,
                                   @RequestBody(required = true) List<ParameterPojo> pojo) {
        try{
            Algorithm algorithm = algorithmService.getAlgorithmById(id);
            InputStream is = algorithmExecuterService.downloadScript(id, dataSetId, testSize, pojo);

            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fileName = algorithm.getName() + " - " + fmt.format(new Date()) + ".py";
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .header("content-disposition", "attachment; filename=" + fileName)
                    .body(new InputStreamResource(is));
        } catch (final Exception exception){
            LOG.error("[POST] /api/{} - {}", getApiName(), exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
