package com.isabelly.qa.tests;

import com.isabelly.qa.base.BaseTest;
import com.isabelly.qa.pages.LoginPage;
import com.isabelly.qa.utils.CsvReader;
import com.isabelly.qa.utils.LoginTestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.isabelly.qa.extensions.ScreenshotExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("regression")
@ExtendWith(ScreenshotExtension.class)
class LoginTest extends BaseTest {

    static Stream<LoginTestData> loginTestData() {

        return CsvReader
                .readLoginData("test-data/login-data.csv")
                .stream();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("loginTestData")
    void loginShouldBehaveAsExpected(LoginTestData testData) {

        LoginPage loginPage = new LoginPage();

        loginPage
                .open()
                .enterUsername(testData.username())
                .enterPassword(testData.password())
                .clickLogin();

        if ("SUCCESS".equals(testData.expectedResult())) {

            assertTrue(
                    loginPage.isLoginSuccessful(),
                    "User should be logged in successfully"
            );

        } else {

            assertTrue(
                    !loginPage.getErrorMessage().isBlank(),
                    "An authentication error should be displayed"
            );
        }
    }
}