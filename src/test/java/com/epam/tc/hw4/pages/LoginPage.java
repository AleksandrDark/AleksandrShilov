package com.epam.tc.hw4.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.util.Property;
import io.qameta.allure.Step;
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
    @FindBy(css = ".login-txt")
    private WebElement loginFail;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Step("open test site url")
    public void openSite() {
        webDriver.navigate().to(URL);
    }

    @Step("assert home {title} and {url}")
    public void testBrowserTitle(String title, String url) {
        assertThat(webDriver.getCurrentUrl()).isEqualTo(url);
        assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    @Step("perform login")
    public void performLogin() {
        userIcon.click();
        String username = Property.readProperty("username");
        String password = Property.readProperty("password");
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    @Step("assert {username} is logged")
    public void testUsername(String username) {
        assertThat(usernameAfterAuthorization.getText()).isEqualTo(username);
    }

    @Step("perform failed Login")
    public void performFailedLogin() {
        userIcon.click();
        String username = Property.readProperty("usernameNotExist");
        String password = Property.readProperty("passwordNotExist");
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    @Step("assert {username} is failed logged")
    public void testFailUsername(String username) {
        assertThat(usernameAfterAuthorization.getText()).isEqualTo(username);
    }
}
