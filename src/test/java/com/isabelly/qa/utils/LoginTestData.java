package com.isabelly.qa.utils;

public record LoginTestData(
        String username,
        String password,
        String expectedResult,
        String testName
) {

    @Override
    public String toString() {
        return testName;
    }
}