package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.util.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private final Property property = new Property();

    @FindBy(css = "a[href='#']")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement usernameAfterAuthorization;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openSite() {
        webDriver.navigate().to(URL);
    }

    public void performLogin() {
        userIcon.click();
        this.username.sendKeys(property.readProperty("username"));
        this.password.sendKeys(property.readProperty("password"));
        loginButton.click();
    }

    public String getUsername() {
        return usernameAfterAuthorization.getText();
    }
}
