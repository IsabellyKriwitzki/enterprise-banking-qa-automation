package com.isabelly.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config/config.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "config.properties not found"
                );
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load configuration",
                    e
            );
        }
    }

    private ConfigReader() {
        // Utility class
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuration property not found: " + key
            );
        }

        return value;
    }

    public static int getIntProperty(String key) {

        return Integer.parseInt(
                getProperty(key)
        );
    }
}