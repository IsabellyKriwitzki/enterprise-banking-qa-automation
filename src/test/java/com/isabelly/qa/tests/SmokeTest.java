package com.isabelly.qa.tests;

import com.isabelly.qa.base.BaseTest;
import org.junit.jupiter.api.Test;
import com.isabelly.qa.config.ConfigReader;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
class SmokeTest extends BaseTest {

    @Test
    void bankingPlatformTestFrameworkIsWorking() {

        String platformName = "Enterprise Banking Platform";

        assertEquals(
                "Enterprise Banking Platform",
                platformName
        );
        String environment = ConfigReader.getProperty("environment");

        System.out.println("Environment: " + environment);
    }
}