package com.isabelly.qa.base;

import com.isabelly.qa.config.ConfigReader;
import com.isabelly.qa.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.isabelly.qa.utils.ScreenshotUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public abstract class BaseTest {

    protected String environment;

    @BeforeEach
    protected void setUp() {

        environment = ConfigReader.getProperty("environment");

        System.out.println("----------------------------------------");
        System.out.println("Starting test execution");
        System.out.println("Environment: " + environment);
        System.out.println("----------------------------------------");

        DriverManager.initializeDriver();
    }

    @AfterEach
    protected void tearDown() {

        DriverManager.quitDriver();

        System.out.println("----------------------------------------");
        System.out.println("Test execution finished");
        System.out.println("----------------------------------------");
    }
}