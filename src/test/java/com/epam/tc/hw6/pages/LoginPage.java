package com.epam.tc.hw6.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw6.util.Property;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("open test site url")
    public void openSite() {
        driver.navigate().to(URL);
    }

    @Step("assert home {title} and {url}")
    public void testBrowserTitle(String title, String url) {
        assertThat(driver.getCurrentUrl()).isEqualTo(url);
        assertThat(driver.getTitle()).isEqualTo(title);
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
