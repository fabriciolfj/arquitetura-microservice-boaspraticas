package com.github.fabriciolfj.util;


import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Scanner;

public class GetFileJson {

    public static String request(final String filename) {
        return read("request/" + filename);
    }

    public static String response(final String filename) {
        return read("response/" + filename);
    }

    private static String read(final String filename) {
        final var stream = GetFileJson.class.getClassLoader().getResourceAsStream("json/" + filename);
        final var file = convertFileToString(stream);
        final var value = StringUtils.replace(file,  "\n", "");
        return value;
    }

    private static String convertFileToString(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream, "UTF-8");
        final String value = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return value;
    }
}
