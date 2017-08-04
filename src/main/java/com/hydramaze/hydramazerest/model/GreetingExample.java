package com.hydramaze.hydramazerest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GreetingExample {

    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private ArrayList<ArrayList<Double>> data;
    @SerializedName("target")
    private ArrayList<Integer> target;

    private double elapsedTime;

    public GreetingExample() { /* Do nothing */ }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ArrayList<Double>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<Double>> data) {
        this.data = data;
    }

    public ArrayList<Integer> getTarget() {
        return target;
    }

    public void setTarget(ArrayList<Integer> target) {
        this.target = target;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}