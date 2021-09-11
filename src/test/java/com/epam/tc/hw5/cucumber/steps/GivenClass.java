package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenClass extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openSite() {
        loginPage.openSite();
    }

    @And("I login as user \"Roman Iovlev\"")
    public void performLogin() {
        loginPage.performLogin();
    }




}
