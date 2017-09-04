package com.hydramaze.hydramazerest.Utils;

public class StringUtils {

    public StringUtils() { /* Do Nothing */ }

    public static String argumentParser(String argumentName, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.TWO_HYPHENS)
                .append(argumentName)
                .append(Constants.EQUAL_SIGN)
                .append(value);

        return stringBuilder.toString();
    }

}
