package com.epam.tc.hw3.testlogic;

import com.epam.tc.hw3.pages.BasePage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import com.epam.tc.hw3.util.DataProviderHelper;
import com.epam.tc.hw3.util.DataProviderPage;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BasePage {

    @Test(dataProvider = "getTextPages", dataProviderClass = DataProviderPage.class)
    public void testHomePage(DataProviderHelper helper) {
        LoginPage loginPage = new LoginPage(webDriver);
        SoftAssertions softAssertions = new SoftAssertions();
        //1. open test site url
        loginPage.openSite();
        //2. assert browser title
        softAssertions.assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(helper.getTitle());
        //3. perform login
        loginPage.performLogin();
        //4. assert username is logged
        softAssertions.assertThat(loginPage.getUsername()).isEqualTo(helper.getUsername());
        //5. assert that there are 4 items on the header section are displayed and they have proper texts
        HomePage homePage = new HomePage(webDriver);
        List<WebElement> elementsOnHeaderSection = homePage.getElementsOnHeaderSection();
        softAssertions.assertThat(elementsOnHeaderSection).hasSize(helper.getCountElementsOnHeaderSection());
        List<String> actualTextListElements = elementsOnHeaderSection.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        softAssertions.assertThat(actualTextListElements).isEqualTo(helper.getExpectedTextListElements());
        //6. assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesOnPage = homePage.getImagesOnPage();
        softAssertions.assertThat(imagesOnPage).hasSize(helper.getCountImagesOnPage());
        //7. assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElementsUnderImages = homePage.getTextElementsUnderImages();
        List<String> textListElementsUnderImages = textElementsUnderImages.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        softAssertions.assertThat(textListElementsUnderImages).isEqualTo(helper.getExpectedTextUnderImages());
        final String windowHandler = webDriver.getWindowHandle();
        //8. assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(homePage.getFrame().isDisplayed()).isTrue();
        //9. switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(helper.getIdFrame());
        String button = homePage.getFrameButton().getAttribute(helper.getButtonAttribute());
        softAssertions.assertThat(homePage.getFrameButton().isDisplayed()).isTrue();
        softAssertions.assertThat(button).isEqualTo(helper.getButtonName());
        //10. switch to original window back
        webDriver.switchTo().window(windowHandler);
        //11. assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarMenuLeft = homePage.getSidebarMenuLeft();
        softAssertions.assertThat(sidebarMenuLeft).hasSize(helper.getCountSidebarMenuLeft());
        List<String> textOnSidebarMenuLeft = sidebarMenuLeft.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        softAssertions.assertThat(textOnSidebarMenuLeft).isEqualTo(helper.getExpectedTextOnSidebarMenuLeft());
        softAssertions.assertAll();
    }
}
