package com.isabelly.qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
        // Prevent object instantiation
    }

    public static void initializeDriver() {

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver has not been initialized. " +
                            "Call initializeDriver() first."
            );
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static boolean isDriverInitialized() {
        return driver != null;
    }
}