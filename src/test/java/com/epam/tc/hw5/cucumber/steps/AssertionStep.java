package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    @Then("Log rows are displayed and radio button,checkbox, dropdown names "
        + "and their status are corresponding to selected on different Page:")
    public void checkTextInLogs(List<String> differentPage) {
        assertThat(differentElementsPage.getLogs()).asString().containsSubsequence(differentPage);
    }

    @Then("{string} page should be opened")
    public void checkOpenedUserPage(String title) {
        assertThat(userTable.getWebDriver().getTitle()).isEqualTo(title);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkCountTypeDropdown(int count) {
        int size = userTable.getUserDropdownValues().size();
        assertThat(size).isEqualTo(count);
        userTable.getUserDropdownValues().forEach(WebElement::isDisplayed);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkCountUserNames(int count) {
        int size = userTable.getUsernames().size();
        assertThat(size).isEqualTo(count);
        userTable.getUsernames().forEach(WebElement::isDisplayed);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkCountDescriptionTextUnderImages(int count) {
        int size = userTable.getUserDescription().size();
        assertThat(size).isEqualTo(count);
        userTable.getUserDescription().forEach(WebElement::isDisplayed);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCountUserCheckboxes(int count) {
        int size = userTable.getUserCheckboxes().size();
        assertThat(size).isEqualTo(count);
        userTable.getUserCheckboxes().forEach(WebElement::isDisplayed);
    }

    @And("User table should contain following values:")
    public void checkContainTextOnUserTableOnUserPage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (int i = 0; rows.size() > i; i++) {
            assertThat(userTable.getNumber().get(i)).isEqualTo(rows.get(i).get("Number"));
            assertThat(userTable.getUsernames().get(i).getText()).isEqualTo(rows.get(i).get("User"));
            assertThat(userTable.getUserDescription().get(i).getText().replaceAll("\n", " "))
                .isEqualTo(rows.get(i).get("Description"));
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void checkContentValuesInTypeForRoman(List<String> table) {
        table = table.subList(1, table.size());
        assertThat(userTable.getDropboxForUserRoman()).isEqualTo(table);
    }

    @Then("1 log row has {string} text in log section\"")
    public void checkLogTextForVipButton(String log) {
        assertThat(userTable.getTextInLogVip()).asString().containsSubsequence(log);
    }

}
