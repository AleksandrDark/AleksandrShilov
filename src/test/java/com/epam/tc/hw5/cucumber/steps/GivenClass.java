package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.Given;

public class GivenClass extends AbstractStep {

    @Given("Open test site by URL")
    public void openSite() {
        loginPage.openSite();
    }

    @Given("Perform login")
    public void performLogin() {
        loginPage.performLogin();
    }

}
