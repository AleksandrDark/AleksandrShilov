package com.epam.tc.hw4.testlogic;

import com.epam.tc.hw4.pages.BasePage;
import com.epam.tc.hw4.pages.LoginPage;
import com.epam.tc.hw4.util.DataProviderHelper;
import com.epam.tc.hw4.util.DataProviderPage;
import com.epam.tc.hw4.util.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Failed test")
@Story("test with not exist user")
@Listeners(ScreenshotListener.class)
public class FailedLoginPageTest extends BasePage {

    @Test(dataProvider = "getTextPages", dataProviderClass = DataProviderPage.class)
    public void testFailedLoginPage(DataProviderHelper dataHelper) {
        LoginPage loginPage = new LoginPage(webDriver);
        //1. open test site url
        loginPage.openSite();
        //2. assert browser title
        loginPage.testBrowserTitle(dataHelper.getTitle());
        //3. perform failed login
        loginPage.performFailedLogin();
        //4. assert incorrect user
        loginPage.testFailUsername(dataHelper.getUsername());
    }

}
