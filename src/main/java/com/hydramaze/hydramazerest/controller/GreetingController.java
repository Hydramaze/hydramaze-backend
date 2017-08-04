package com.hydramaze.hydramazerest.controller;

import com.google.gson.Gson;
import com.hydramaze.hydramazerest.business.PythonBusiness;
import com.hydramaze.hydramazerest.model.Greeting;
import com.hydramaze.hydramazerest.model.GreetingExample;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private PythonBusiness pythonBusiness;

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/greeting")
    public GreetingExample greeting(@RequestParam(value="name", defaultValue="World") String name) {

        pythonBusiness = new PythonBusiness();
        pythonBusiness.startProcess("hello.py");

        Gson gson = new Gson();
        GreetingExample greetingExample = gson.fromJson(pythonBusiness.getOutput().toString(), GreetingExample.class);
        greetingExample.setElapsedTime(pythonBusiness.getEstimatedTime());

        return greetingExample;
    }

}
