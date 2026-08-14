package com.isabelly.qa.utils;

import com.isabelly.qa.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtils {

    private ScreenshotUtils() {
        // Utility class
    }

    public static String takeScreenshot(String testName) {

        try {

            TakesScreenshot screenshot =
                    (TakesScreenshot) DriverManager.getDriver();

            File sourceFile =
                    screenshot.getScreenshotAs(OutputType.FILE);

            Path screenshotDirectory =
                    Path.of("target", "screenshots");

            Files.createDirectories(screenshotDirectory);

            Path destination =
                    screenshotDirectory.resolve(
                            sanitizeFileName(testName) + ".png"
                    );

            Files.copy(
                    sourceFile.toPath(),
                    destination,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );

            return destination.toString();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to save screenshot for test: " + testName,
                    e
            );
        }
    }

    private static String sanitizeFileName(String fileName) {

        return fileName.replaceAll(
                "[^a-zA-Z0-9._-]",
                "_"
        );
    }
}