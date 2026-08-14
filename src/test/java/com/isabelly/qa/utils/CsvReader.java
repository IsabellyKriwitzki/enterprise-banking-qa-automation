package com.isabelly.qa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private CsvReader() {
        // Utility class
    }

    public static List<LoginTestData> readLoginData(String resourcePath) {

        List<LoginTestData> records = new ArrayList<>();

        try (InputStream inputStream = CsvReader.class
                .getClassLoader()
                .getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new IllegalArgumentException(
                        "CSV resource not found: " + resourcePath
                );
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream))) {

                // Skip CSV header
                reader.readLine();

                String line;

                while ((line = reader.readLine()) != null) {

                    if (!line.isBlank()) {

                        String[] values = line.split(",", -1);

                        if (values.length != 4) {
                            throw new IllegalArgumentException(
                                    "Invalid CSV record: " + line
                            );
                        }

                        records.add(
                                new LoginTestData(
                                        values[0].trim(),
                                        values[1].trim(),
                                        values[2].trim(),
                                        values[3].trim()
                                )
                        );
                    }
                }
            }

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to read CSV file: " + resourcePath,
                    e
            );
        }

        return records;
    }
}