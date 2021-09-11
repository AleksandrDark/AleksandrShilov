package com.epam.tc.hw5.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.util.Property;
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
    @FindBy(css = "li.menu-title")
    private WebElement headerMenu;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openSite() {
        webDriver.navigate().to(URL);
    }

    public void testBrowserTitle(String title, String url) {
        assertThat(webDriver.getCurrentUrl()).isEqualTo(url);
        assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    public void performLogin() {
        userIcon.click();
        String username = Property.readProperty("username");
        String password = Property.readProperty("password");
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void testUsername(String username) {
        assertThat(usernameAfterAuthorization.getText()).isEqualTo(username);
    }

    public void openServiceMenu() {
        headerMenu.click();
    }
}
