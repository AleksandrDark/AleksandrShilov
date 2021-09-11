package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import org.assertj.core.api.Assertions;

public class AssertionStep extends AbstractStep {

    @Then("Log rows are displayed and radio button,checkbox, dropdown names "
        + "and their status are corresponding to selected on different Page:")
    public void checkTextInLogs(List<String> differentPage) {
        differentElementsPage.checkLogs(differentPage);
    }



    @Then("{string} page should be opened")
    public void checkOpenedUserPage(String title) {
        assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkCountTypeDropdown(int count) {
        int size = userTable.getUserDropdownValues().size();
        assertThat(size).isEqualTo(count);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkCountUserNames(int count) {
        int size = userTable.getUsernames().size();
        assertThat(size).isEqualTo(count);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkCountDescriptionTextUnderImages(int count) {
        int size = userTable.getUsernames().size();
        assertThat(size).isEqualTo(count);
    }
}
