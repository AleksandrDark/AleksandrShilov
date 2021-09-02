package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.DriverInit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class HomePageTest extends DriverInit {

    @Test
    public void testHomePage() {
        SoftAssertions softAssertions = new SoftAssertions();
        //1. open test site url
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(url);
        //2. assert browser title
        softAssertions.assertThat(webDriver.getCurrentUrl()).isEqualTo(url);
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //3. perform login
        webDriver.findElement(By.cssSelector(".uui-profile-menu > a")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        //4. assert username is logged
        WebElement webElement = webDriver.findElement(By.id("user-name"));
        softAssertions.assertThat(webElement.getText()).isEqualTo("ROMAN IOVLEV");
        //5. assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> elementsOnHeaderSection = webDriver.findElements(By.cssSelector(".m-l8 > li > a"));
        List<String> expectedTextListElements = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssertions.assertThat(elementsOnHeaderSection).hasSize(expectedTextListElements.size());
        List<String> actualTextListElements = elementsOnHeaderSection.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        softAssertions.assertThat(actualTextListElements).isEqualTo(expectedTextListElements);
        //6. assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesOnPage = webDriver.findElements(By.cssSelector(".benefit-icon"));
        List<String> expectedTextUnderImages =
            Stream.of("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…")
                .collect(Collectors.toList());
        softAssertions.assertThat(imagesOnPage).hasSize(expectedTextUnderImages.size());
        //7. assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElementsUnderImages = webDriver.findElements(By.cssSelector(".benefit-txt"));
        List<String> textListElementsUnderImages = textElementsUnderImages.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softAssertions.assertThat(textListElementsUnderImages).isEqualTo(expectedTextUnderImages);
        final String windowHandler = webDriver.getWindowHandle();
        //8. assert that there is the iframe with “Frame Button” exist
        webElement = webDriver.findElement(By.id("frame"));
        softAssertions.assertThat(webElement.isDisplayed()).isTrue();
        //9. switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        String button = webDriver.findElement(By.id("frame-button")).getAttribute("value");
        webDriver.findElement(By.id("frame-button")).click();
        softAssertions.assertThat(button).isEqualTo("Frame Button");
        //10. switch to original window back
        webDriver.switchTo().window(windowHandler);
        //11. assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarMenuLeft =
            webDriver.findElements(By.cssSelector(".uui-side-bar .sidebar-menu > li > a"));
        List<String> expectedTextOnSidebarMenuLeft = Arrays.asList("Home", "Contact form", "Service",
            "Metals & Colors", "Elements packs");
        softAssertions.assertThat(sidebarMenuLeft).hasSize(expectedTextOnSidebarMenuLeft.size());
        List<String> textOnSidebarMenuLeft = sidebarMenuLeft.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softAssertions.assertThat(textOnSidebarMenuLeft).isEqualTo(expectedTextOnSidebarMenuLeft);
        softAssertions.assertAll();
    }
}
