package com.epam.tc.hw3.testlogic;

import com.epam.tc.hw3.pages.BasePage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTest extends BasePage {
    @Test
    public void testHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        SoftAssertions softAssertions = new SoftAssertions();
        //1. open test site url
        loginPage.openSite();
        //2. assert browser title
        softAssertions.assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //3. perform login
        loginPage.performLogin();
        //4. assert username is logged
        softAssertions.assertThat(loginPage.getUsername()).isEqualTo("ROMAN IOVLEV");
        //5. assert that there are 4 items on the header section are displayed and they have proper texts
        HomePage homePage = new HomePage(webDriver);
        List<WebElement> elementsOnHeaderSection = homePage.getElementsOnHeaderSection();
        softAssertions.assertThat(elementsOnHeaderSection).hasSize(4);
        List<String> actualTextListElements = elementsOnHeaderSection.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        List<String> expectedTextListElements = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssertions.assertThat(actualTextListElements).isEqualTo(expectedTextListElements);
        //6. assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesOnPage = homePage.getImagesOnPage();
        softAssertions.assertThat(imagesOnPage).hasSize(4);
        //7. assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElementsUnderImages = homePage.getTextElementsUnderImages();
        List<String> textListElementsUnderImages = textElementsUnderImages.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        List<String> expectedTextUnderImages =
            Stream.of("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…")
                .collect(Collectors.toList());
        softAssertions.assertThat(textListElementsUnderImages).isEqualTo(expectedTextUnderImages);
        final String windowHandler = webDriver.getWindowHandle();
        //8. assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(homePage.getFrame().isDisplayed()).isTrue();
        //9. switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(0);
        String button = homePage.getFrameButton().getAttribute("value");
        softAssertions.assertThat(homePage.getFrameButton().isDisplayed()).isTrue();
        softAssertions.assertThat(button).isEqualTo("Frame Button");
        //10. switch to original window back
        webDriver.switchTo().window(windowHandler);
        //11. assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarMenuLeft = homePage.getSidebarMenuLeft();
        softAssertions.assertThat(sidebarMenuLeft).hasSize(5);
        List<String> textOnSidebarMenuLeft = sidebarMenuLeft.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        List<String> expectedTextOnSidebarMenuLeft = Arrays.asList("Home", "Contact form", "Service",
            "Metals & Colors", "Elements packs");
        softAssertions.assertThat(textOnSidebarMenuLeft).isEqualTo(expectedTextOnSidebarMenuLeft);
        softAssertions.assertAll();
    }
}
