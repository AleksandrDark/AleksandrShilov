package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I click on \"Service\" button in Header")
    public void openServiceMenu() {
        loginPage.openServiceMenu();
    }

    @And("I click on \"Different Elements Page\" button in Service dropdown")
    public void openDifferentElement() {
        differentElementsPage.openDifferentElement();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void openUserTable() {
        userTable.openUserTable();
    }

    @And("Select checkboxes 'Water, Wind'")
    public void selectCheckboxes() {
        differentElementsPage.selectCheckBoxWater();
        differentElementsPage.selectCheckBoxWind();
    }

    @And("Select radio Selen")
    public void selectRadio() {
        differentElementsPage.selectRadioSelen();
    }

    @And("Select in dropdown {string}")
    public void selectDropdown(String color) {
        differentElementsPage.selectDropdownYellow(color);
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipButtonForSergeyIvan() {
        userTable.clickButtonVipInCheckboxSergeyIvan();
    }
}
