package com.hydramaze.hydramazerest.business;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonBusiness {

    private Process process;
    private ProcessBuilder processBuilder;
    private JSONObject jsonObjectResult = null;
    private double estimatedTime;

    public PythonBusiness() { /* Do nothing */ }

    private void processBuilder(String scriptName) {
        processBuilder = new ProcessBuilder("python", scriptName);
        processBuilder.directory(new File(getClass().getClassLoader().getResource("pyscripts").getPath()));
    }

    public void startProcess(String scriptName) {
        try {
            processBuilder(scriptName);
            long startTime = System.nanoTime();
            process = processBuilder.start();
            process.waitFor();
            estimatedTime = (System.nanoTime() - startTime) / 1000000000.0;

            System.out.println("Time elapsed: " + estimatedTime);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            process.destroy();
        }
    }

    public JSONObject getOutput() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));

            StringBuilder responseStrBuilder = new StringBuilder();
            String last = null, line;

            while ((line = input.readLine()) != null) {
                last = line;
            }

            try {
                jsonObjectResult = new JSONObject(last);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObjectResult;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    private void processBuilder(String[] parameters) {
        processBuilder = new ProcessBuilder(parameters);
        processBuilder.directory(new File(getClass().getClassLoader().getResource("pyscripts").getPath()));
    }

    public void startProcess(String[] scriptName) {
        try {
            processBuilder(scriptName);
            long startTime = System.nanoTime();
            process = processBuilder.start();
            process.waitFor();
            estimatedTime = (System.nanoTime() - startTime) / 1000000000.0;
            printProcessOutput();
            System.out.println("Time elapsed: " + estimatedTime);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            process.destroy();
        }
    }

    private void printProcessOutput(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
