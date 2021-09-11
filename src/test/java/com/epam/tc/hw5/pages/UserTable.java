package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTable {

    @FindBy(linkText = "User Table")
    private WebElement userTable;
    @FindBy(xpath = "//select")
    private List<WebElement> userDropdownValues;
    @FindBy(xpath = "//td//a")
    private List<WebElement> usernames;
    @FindBy(xpath = "//div[@class='user-descr']//span")
    private List<WebElement> userDescription;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> userCheckboxes;

    public void openUserTable() {
        userTable.click();
    }

    public List<WebElement> getUserDropdownValues() {
        return userDropdownValues;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getUserDescription() {
        return userDescription;
    }

}
