package com.isabelly.qa.extensions;

import com.isabelly.qa.driver.DriverManager;
import com.isabelly.qa.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.FileInputStream;
import java.io.IOException;

public class ScreenshotExtension implements TestWatcher {

    @Override
    public void testFailed(
            ExtensionContext context,
            Throwable cause) {

        String testName = context.getDisplayName();

        if (DriverManager.isDriverInitialized()) {

            String screenshotPath =
                    ScreenshotUtils.takeScreenshot(testName);

            System.out.println(
                    "Screenshot saved: " + screenshotPath
            );

            try (FileInputStream screenshot =
                         new FileInputStream(screenshotPath)) {

                Allure.addAttachment(
                        "Screenshot - " + testName,
                        "image/png",
                        screenshot,
                        ".png"
                );

            } catch (IOException e) {

                System.err.println(
                        "Could not attach screenshot to Allure: "
                                + e.getMessage()
                );
            }
        }
    }
}

