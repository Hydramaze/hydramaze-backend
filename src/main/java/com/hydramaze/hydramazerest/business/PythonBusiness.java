package com.hydramaze.hydramazerest.business;

import com.hydramaze.hydramazerest.model.PythonRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;

public class PythonBusiness {

    private static final String SCRIPTS_FOLDER_NAME = "pyscripts";

    private Process process;
    private ProcessBuilder processBuilder;
    private JSONObject jsonObjectResult = null;
    private double estimatedTime;

    // Public Methods
    public PythonBusiness() { /* Do nothing */ }

    public void startProcessCall(PythonRequest pythonRequest) {
        try {
            processBuilder(pythonRequest.getCommand());
            long startTime = System.nanoTime();
            process = processBuilder.start();
            process.waitFor();
            estimatedTime = (System.nanoTime() - startTime) / 1000000000.0;
            printProcessOutput();
            //getOutputAsJSONObject();
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

    public double getEstimatedTime() {
        return estimatedTime;
    }

    // Private Methods
    private void processBuilder(ArrayList params) throws UnsupportedEncodingException {
        String folderPath = URLDecoder.decode(ClassLoader.getSystemResource(SCRIPTS_FOLDER_NAME).getFile(), "UTF-8");

        if (folderPath != null && !folderPath.isEmpty()) {
            processBuilder = new ProcessBuilder(params);
            processBuilder.directory(new File(folderPath));
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

    private JSONObject getOutputAsJSONObject() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));

            String last = null;
            String line;

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObjectResult;
    }

}
