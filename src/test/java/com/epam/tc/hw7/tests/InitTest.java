package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.entities.User.ROMAN;
import static com.epam.tc.hw7.site.JdiTestSite.open;
import static com.epam.tc.hw7.site.pages.HomePage.loginAs;

import com.epam.tc.hw7.site.JdiTestSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface InitTest {

    @BeforeSuite
    static void setUpMethod() {
        initSite(JdiTestSite.class);
        open();
        loginAs(ROMAN);
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
