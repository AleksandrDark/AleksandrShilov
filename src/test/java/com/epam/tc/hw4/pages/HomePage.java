package com.epam.tc.hw4.pages;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> elementsOnHeaderSection;
    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesOnPage;
    @FindBy(css = ".benefit-txt")
    private List<WebElement> textElementsUnderImages;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @FindBy(css = ".uui-side-bar .sidebar-menu > li > a")
    private List<WebElement> sidebarMenuLeft;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Step("assert that there are 4 images on the Index Page and they are displayed")
    public void testElementsOnHeaderSection(int countElementsOnHeaderSection, List<String> expectedTextListElements) {
        assertThat(elementsOnHeaderSection).hasSize(countElementsOnHeaderSection);
        List<String> actualTextListElements = elementsOnHeaderSection.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(actualTextListElements).isEqualTo(expectedTextListElements);
    }

    @Step("assert that there are 4 images on the Index Page and they are displayed")
    public void testCountImagesOnPage(int countImagesOnPage) {
        assertThat(imagesOnPage).hasSize(countImagesOnPage);
    }

    @Step("assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void testTextElementsUnderImages(List<String> expectedTextUnderImages) {
        List<String> textListElementsUnderImages = textElementsUnderImages.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textListElementsUnderImages).isEqualTo(expectedTextUnderImages);
    }

    @Step("assert that there is the iframe with “Frame Button” exist")
    public void testIsFrame() {
        assertThat(frame.isDisplayed()).isTrue();
    }

    @Step("switch to the iframe")
    public void switchToFrame(String idFrame) {
        webDriver.switchTo().frame(idFrame);
    }

    @Step("check that there is “Frame Button” in the iframe")
    public void testFrameButton(String buttonAttribute, String buttonName) {
        String button = frameButton.getAttribute(buttonAttribute);
        assertThat(frameButton.isDisplayed()).isTrue();
        assertThat(button).isEqualTo(buttonName);
    }

    @Step("switch to original window back")
    public void switchToHomePage() {
        webDriver.switchTo().defaultContent();
    }

    @Step("assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void testSidebarMenuLeft(int countSidebarMenuLeft, List<String> expectedTextOnSidebarMenuLeft) {
        assertThat(sidebarMenuLeft).hasSize(countSidebarMenuLeft);
        List<String> textOnSidebarMenuLeft = sidebarMenuLeft.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textOnSidebarMenuLeft).isEqualTo(expectedTextOnSidebarMenuLeft);
    }
}
