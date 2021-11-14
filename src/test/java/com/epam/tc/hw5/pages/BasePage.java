package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

}
