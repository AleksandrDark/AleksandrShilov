package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverElement {

    protected WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void clear() {
        webDriver.close();
    }
}
