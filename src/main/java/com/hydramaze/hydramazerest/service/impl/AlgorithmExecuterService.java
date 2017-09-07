package com.hydramaze.hydramazerest.service.impl;

import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.enums.Component;
import com.hydramaze.hydramazerest.model.Algorithm;
import com.hydramaze.hydramazerest.model.DataSet;
import com.hydramaze.hydramazerest.model.Parameter;
import com.hydramaze.hydramazerest.model.PythonRequest;
import com.hydramaze.hydramazerest.pojo.ParameterPojo;
import com.hydramaze.hydramazerest.service.IAlgorithmExecuterService;
import com.hydramaze.hydramazerest.service.IAlgorithmService;
import com.hydramaze.hydramazerest.service.IParameterService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlgorithmExecuterService implements IAlgorithmExecuterService {

    @Autowired
    private IAlgorithmService algorithmService;

    @Autowired
    private IParameterService parameterService;

    @Override
    public JSONObject executeScript(Integer algorithmId, Integer dataSetId, Double learningCurve, List<ParameterPojo> pojoList) throws Exception {
        Algorithm algorithm = algorithmService.getAlgorithmById(algorithmId);
        DataSet dataSet = getDataSet(algorithm, dataSetId);

        validateLearningCurve(learningCurve);
        validateParameters(algorithm, pojoList);

        PythonRequest pythonRequest = new PythonRequest(algorithm.getScriptName());
        pythonRequest.addArgumentWithName("dataset", dataSet.getPythonDataSetName());
        pythonRequest.addArgumentWithName("test_size", learningCurve);

        for (ParameterPojo pojo : pojoList) {
            Parameter parameter = algorithm.getParameterList().stream()
                    .filter(p -> pojo.getParameterId().equals(p.getId())).collect(Collectors.toList()).get(0);
            pythonRequest.addArgumentWithName(parameter.getPythonArgumentName(), pojo.getValue());
        }

        PythonBusiness pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcessCall(pythonRequest);
        return pythonBusiness.getJsonObjectResult().getJSONObject("data");
    }

    private DataSet getDataSet(Algorithm algorithm, Integer dataSetId) throws Exception {
        List<DataSet> dataSetList = algorithm.getDataSetList().stream().filter(d -> dataSetId.equals(d.getId())).collect(Collectors.toList());

        // Valida se o dataset pertence ao algoritmo
        if (dataSetList.isEmpty()) {
            throw new Exception("The dataset with id '" + dataSetId + "' does not belong to the algorithm '" + algorithm.getName() + "'");
        } else {
            return dataSetList.get(0);
        }
    }

    private void validateLearningCurve(Double learningCurve) throws Exception {
        // Valida a quantidade destinada ao aprendizado
        if (learningCurve < .1 || learningCurve > .9) {
            throw new Exception("The learning curve should be between 0.1 and 0.9");
        }
    }

    private void validateParameters(Algorithm algorithm, List<ParameterPojo> pojoList) throws Exception {
        for (ParameterPojo pojo : pojoList) {
            Parameter parameter = parameterService.getParameterById(pojo.getParameterId());
            String componentName = parameter.getComponent();

            // Valida se a quantidade de parâmetros passado é a mesma que foi recebida
            if (algorithm.getParameterList().size() != pojoList.size()) {
                throw new Exception("The algorithm has '" + algorithm.getParameterList().size() + "' parameters and received only '" + pojoList.size() + "'");
            }

            // Valida se pertence ao algoritmo
            if (!algorithm.getParameterList().contains(parameter)) {
                throw new Exception("The paramater '" + parameter.getName() + "' does not belong to the algorithm '" + algorithm.getName() + "'");
            }
            // Valida componente combo-box
            else if (componentName.equals(Component.COMBO_BOX.getComponentName())) {
                if(!(parameter.getListData().contains(pojo.getValue()))) {
                    throw new Exception("The value '" + pojo.getValue() + "' for field '" + parameter.getName() + "' not correspond to the allowed values: " + parameter.getListData());
                }
            }
            // Valida componente check-box
            else if (componentName.equals(Component.CHECK_BOX.getComponentName())) {
                if(!(pojo.getValue().equals("true") || pojo.getValue().equals("false"))) {
                    throw new Exception("The value '" + pojo.getValue() + "' for field '" + parameter.getName() + "' is not a boolean value");
                }
            }
            // Valida componente input-number
            else if (componentName.equals(Component.INPUT_NUMBER.getComponentName())) {
                try {
                    if (!parameter.getDefaultValue().equals(pojo.getValue())) {
                        Double value = Double.parseDouble(pojo.getValue());
                        if (parameter.getMinValue() != null && value < parameter.getMinValue()) {
                            throw new Exception("The value '" + pojo.getValue() + "' for field '" + parameter.getName() + "' is less than '" + parameter.getMinValue() + "'");
                        } else if (parameter.getMaxValue() != null && value > parameter.getMaxValue()) {
                            throw new Exception("The value '" + pojo.getValue() + "' for field '" + parameter.getName() + "' is greater than '" + parameter.getMaxValue() + "'");
                        }
                    }
                } catch (Exception e) {
                    throw new Exception("The value '" + pojo.getValue() + "' for field '" + parameter.getName() + "' is not a number value");
                }
            }
        }
    }
}
