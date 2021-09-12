package com.epam.tc.hw5.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

//    @BeforeMethod
//    public WebDriver setupChromeDriver(ITestContext context) {
//        WebDriverManager.chromedriver().setup();
//        webDriver = new ChromeDriver();
//        context.setAttribute("webDriver", webDriver);
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        return webDriver;
//    }
//
//    @AfterMethod
//    public void closeDriver() {
//        if (webDriver != null) {
//            webDriver.close();
//        }
//        webDriver = null;
//    }
}
