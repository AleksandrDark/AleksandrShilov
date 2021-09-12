package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTable extends BasePage {

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
    @FindBy(xpath = "//tbody//tr//td[1]")
    private List<WebElement> number;
    @FindBy(xpath = "//tr[1]//td[2]//select[1]/*")
    private List<WebElement> dropboxForUserRoman;
    @FindBy(id = "ivan")
    private WebElement buttonVipInCheckboxSergeyIvan;
    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> textInLogVip;


    public UserTable(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

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

    public List<WebElement> getUserCheckboxes() {
        return userCheckboxes;
    }

    public List<String> getNumber() {
        List<String> stringNumbers = new ArrayList<>();
        number.stream().map(WebElement::getText).forEach(stringNumbers::add);
        return stringNumbers;
    }

    public List<String> getDropboxForUserRoman() {
        return dropboxForUserRoman.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickButtonVipInCheckboxSergeyIvan() {
        buttonVipInCheckboxSergeyIvan.click();
    }

    public List<String> getTextInLogVip() {
        return textInLogVip.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
