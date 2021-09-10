package com.epam.tc.hw5.testlogic;

import com.epam.tc.hw5.pages.BasePage;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.LoginPage;
import com.epam.tc.hw5.util.DataProviderHelper;
import com.epam.tc.hw5.util.DataProviderPage;
import com.epam.tc.hw5.util.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Different page test")
@Story("Test functionality different elements on page")
@Listeners(ScreenshotListener.class)
public class DifferentElementsPageTest extends BasePage {

    @Test(dataProvider = "getTextPages", dataProviderClass = DataProviderPage.class)
    public void testDifferentElementsOnPage(DataProviderHelper providerHelper) {
        LoginPage loginPage = new LoginPage(webDriver);
        //1. Open test site by URL
        loginPage.openSite();
        //2. Assert Browser title "Home Page"
        loginPage.testBrowserTitle(providerHelper);
        //3. Perform login
        loginPage.performLogin();
        //4. Assert User name in the left-top side of screen is "ROMAN IOVLEV"
        loginPage.testUsername(providerHelper);
        //5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
        differentElementsPage.openServiceMenu();
        differentElementsPage.openDifferentElement();
        //6. Select checkboxes "Water, Wind"
        differentElementsPage.selectCheckBoxWater();
        differentElementsPage.selectCheckBoxWind();
        //7. Select radio "Selen"
        differentElementsPage.selectRadioSelen();
        //8. Select in dropdown "Yellow"
        differentElementsPage.selectDropdownYellow(providerHelper);
        //9. Assert that checkbox, radio button, radio button names are corresponding to selected
        differentElementsPage.checkLogs(providerHelper);
    }
}
