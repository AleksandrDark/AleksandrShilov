package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected LoginPage loginPage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        loginPage = new LoginPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

}
