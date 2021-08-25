package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverElement {

    protected WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void clear() {
        webDriver.close();
    }
}
