package com.hydramaze.hydramazerest.business;

import com.hydramaze.hydramazerest.model.PythonRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PythonBusiness {

    private static final String SCRIPTS_FOLDER_NAME = "pyscripts";
    private static final int PROCESS_TIMEOUT = 60;

    private Process process;
    private ProcessBuilder processBuilder;
    private JSONObject jsonObjectResult = null;
    private double elapsedTime;

    // Public Methods
    public PythonBusiness() { /* Do nothing */ }

    public void startProcessCall(PythonRequest pythonRequest) {
        try {
            processBuilder(pythonRequest.getCommand());
            long startTime = System.nanoTime();
            //processBuilder.redirectErrorStream(true);
            process = processBuilder.start();

            if(!process.waitFor(PROCESS_TIMEOUT, TimeUnit.SECONDS)) {
                process.destroy();
            } else {
                getOutputAsJSONObject();
            }

            elapsedTime = TimeUnit.MILLISECONDS.convert((System.nanoTime() - startTime), TimeUnit.NANOSECONDS) / 1000.0;
            System.out.println("Time elapsed: " + elapsedTime);

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

    public double getElapsedTime() {
        return elapsedTime;
    }

    // Private Methods
    private void processBuilder(ArrayList params) throws UnsupportedEncodingException {
        String folderPath = URLDecoder.decode(getClass().getClassLoader().getResource(SCRIPTS_FOLDER_NAME).getFile(), "UTF-8");

        if (folderPath != null && !folderPath.isEmpty()) {
            processBuilder = new ProcessBuilder(params);
            processBuilder.directory(new File(folderPath));
        }
    }

    private void getOutputAsJSONObject() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "UTF-8"));

            String line = input.readLine();
            String last = line;

            while (line != null) {
                line = input.readLine();
                if (line != null) {
                    last = line;
                }
            }

            try {
                if (last != null) {
                    jsonObjectResult = new JSONObject(last);
                } else {
                    throw new JSONException("Parse Error");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJsonObjectResult() {
        return jsonObjectResult;
    }
}
