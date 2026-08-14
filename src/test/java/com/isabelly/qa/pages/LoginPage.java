package com.isabelly.qa.pages;

import com.isabelly.qa.config.ConfigReader;
import com.isabelly.qa.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField =
            By.id("user-name");

    private final By passwordField =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    private final By errorMessage =
            By.cssSelector("[data-test='error']");

    public LoginPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getIntProperty("explicit.wait")
                )
        );
    }

    public LoginPage open() {

        driver.get(
                ConfigReader.getProperty("base.url")
        );

        return this;
    }

    public LoginPage enterUsername(String username) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField
                )
        ).sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        ).sendKeys(password);

        return this;
    }

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();
    }

    public boolean isLoginSuccessful() {

        WebElement productsTitle =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.className("title")
                        )
                );

        return productsTitle.isDisplayed()
                && productsTitle.getText().equals("Products");
    }

    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessage
                )
        ).getText();
    }
}