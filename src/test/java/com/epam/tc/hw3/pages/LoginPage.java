package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.util.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = ".uui-profile-menu > a")
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
        String username = Property.readProperty("username");
        String password = Property.readProperty("password");
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getUsername() {
        return usernameAfterAuthorization.getText();
    }
}
