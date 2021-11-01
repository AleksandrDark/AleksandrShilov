package com.epam.tc.hw6.testlogic;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver driver;

    @BeforeMethod
    public void setupDriver(ITestContext context) {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
    }
}
