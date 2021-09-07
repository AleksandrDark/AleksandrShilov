package com.epam.tc.hw4.testlogic;

import com.epam.tc.hw4.pages.BasePage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.pages.LoginPage;
import com.epam.tc.hw4.util.DataProviderHelper;
import com.epam.tc.hw4.util.DataProviderPage;
import com.epam.tc.hw4.util.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Feature("Home Page Test")
@Story("Test base functionality on home page and displaying information")
@Severity(SeverityLevel.CRITICAL)
@Listeners(ScreenshotListener.class)
public class HomePageTest extends BasePage {

    @Test(dataProvider = "getTextPages", dataProviderClass = DataProviderPage.class)
    public void testHomePage(DataProviderHelper dataHelper) {
        LoginPage loginPage = new LoginPage(webDriver);
        //1. open test site url
        loginPage.openSite();
        //2. assert browser title
        loginPage.testBrowserTitle(dataHelper);
        //3. perform login
        loginPage.performLogin();
        //4. assert username is logged
        loginPage.testUsername(dataHelper);
        //5. assert that there are 4 items on the header section are displayed and they have proper texts
        HomePage homePage = new HomePage(webDriver);
        homePage.testElementsOnHeaderSection(dataHelper);
        //6. assert that there are 4 images on the Index Page and they are displayed
        homePage.testCountImagesOnPage(dataHelper);
        //7. assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.testTextElementsUnderImages(dataHelper);
        //final String windowHandler = webDriver.getWindowHandle();
        //8. assert that there is the iframe with “Frame Button” exist
        homePage.testIsFrame();
        //9. switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame(dataHelper);
        homePage.testFrameButton(dataHelper);
        //10. switch to original window back
        homePage.switchToHomePage();
        //11. assert that there are 5 items in the Left Section are displayed and they have proper text
        homePage.testSidebarMenuLeft(dataHelper);
    }
}
