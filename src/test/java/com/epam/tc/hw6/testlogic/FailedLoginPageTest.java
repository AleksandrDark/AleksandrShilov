package com.epam.tc.hw6.testlogic;

import com.epam.tc.hw6.pages.LoginPage;
import com.epam.tc.hw6.util.DataProviderPage;
import com.epam.tc.hw6.util.DataProviderUtil;
import com.epam.tc.hw6.util.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Failed test")
@Story("test with not exist user")
@Listeners(ScreenshotListener.class)
public class FailedLoginPageTest extends BaseTest {

    @Test(dataProvider = "getTextPages", dataProviderClass = DataProviderPage.class)
    public void testFailedLoginPage(DataProviderUtil provider) {
        //1. open test site url
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSite();
        //2. assert browser title
        loginPage.testBrowserTitle(provider.getTitle(), URL);
        //3. perform failed login
        loginPage.performFailedLogin();
        //4. assert incorrect user
        loginPage.testFailUsername(provider.getUsername());
    }
}
