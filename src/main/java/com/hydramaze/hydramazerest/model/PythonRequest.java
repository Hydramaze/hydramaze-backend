package com.hydramaze.hydramazerest.model;

import com.hydramaze.hydramazerest.Utils.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class PythonRequest<T> {

    private static final String PYTHON_COMMAND = "python";

    private ArrayList<String> command;

    public PythonRequest(@NotNull String scriptName) {
        this.command = new ArrayList<>();
        this.command.add(PYTHON_COMMAND);
        this.command.add(scriptName);
    }

    public PythonRequest<T> addParameter(@NotNull T obj) {
        command.add(obj.toString());
        return this;
    }

    public ArrayList<String> getCommand() {
        return command;
    }

    public PythonRequest<T> addArgumentWithName(@NotNull String argumentName,@NotNull T objValue) {
        command.add(StringUtils.argumentParser(argumentName, objValue.toString()));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s : command){
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }
}
