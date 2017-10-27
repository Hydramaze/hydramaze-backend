package com.hydramaze.hydramazerest.controller;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.hydramaze.hydramazerest.service.IAlgorithmService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/git")
public class GitHubController {

    private static final Logger LOG = LoggerFactory.getLogger(GitHubController.class);

    @Autowired
    private IAlgorithmService algorithmService;

    private List<Object> contributors = new ArrayList<>();


    private String getApiName() {
        return "git";
    }


    @RequestMapping(value = "/contributor", method = RequestMethod.GET)
    public ResponseEntity getAlgorithm() {
        try{
            return new ResponseEntity<>(contributors, HttpStatus.OK);
        } catch (final Exception exception){
            LOG.error("[GET] /api/{} - {}", getApiName(), exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostConstruct
    private void initContributors() {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://api.github.com/orgs/hydramaze/repos");

            CloseableHttpResponse response = client.execute(httpGet);
            int code = response.getStatusLine().getStatusCode();

            if (code == HttpStatus.OK.value()) {
                String stringResponse = EntityUtils.toString(response.getEntity());
                List repositorioList = new Gson().fromJson(stringResponse, List.class);

                for (Object repositorio: repositorioList) {
                    Map rep = (Map) repositorio;
                    String urlContributors = "https://api.github.com/repos/hydramaze/" + rep.get("name") +"/stats/contributors";

                    requestUserData(urlContributors);
                }

                contributors = contributors.stream().distinct().collect(Collectors.toList());
            }
        } catch (Exception exception) {
            LOG.error("[GET] /api/{} - {}", getApiName(), exception);
        }
    }

    private void requestUserData(String urlContributors) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(urlContributors);

            CloseableHttpResponse response = client.execute(httpGet);
            int code = response.getStatusLine().getStatusCode();

            if (code == HttpStatus.OK.value()) {
                String stringResponse = EntityUtils.toString(response.getEntity());
                List repData = new Gson().fromJson(stringResponse, List.class);

                for (int i = 0; i < repData.size(); i++ ) {
                    contributors.add(((LinkedTreeMap) repData.get(i)).get("author"));
                }
            }
        } catch (Exception exception) {
            LOG.error("[GET] /api/{} - {}", getApiName(), exception);
        }
    }

}
