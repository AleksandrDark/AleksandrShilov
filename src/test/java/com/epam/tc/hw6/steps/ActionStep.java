package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.HomePage;
import com.epam.tc.hw6.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class ActionStep {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public ActionStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

}
