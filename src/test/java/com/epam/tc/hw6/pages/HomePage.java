package com.epam.tc.hw6.pages;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        super(webDriver);
    }

    @Step("check that there are {countElementsOnHeaderSection} images on the Index Page "
        + "and expected text are {expectedTextListElements}")
    public void testElementsOnHeaderSection(int countElementsOnHeaderSection, List<String> expectedTextListElements) {
        assertThat(elementsOnHeaderSection).hasSize(countElementsOnHeaderSection);
        List<String> actualTextListElements = elementsOnHeaderSection.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(actualTextListElements).isEqualTo(expectedTextListElements);
    }

    @Step("assert that there are {countImagesOnPage} images on the Index Page")
    public void testCountImagesOnPage(int countImagesOnPage) {
        assertThat(imagesOnPage).hasSize(countImagesOnPage);
    }

    @Step("assert that there are 4 texts on the Index Page under icons and they have {expectedTextUnderImages}")
    public void testTextElementsUnderImages(List<String> expectedTextUnderImages) {
        List<String> textListElementsUnderImages = textElementsUnderImages.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textListElementsUnderImages).isEqualTo(expectedTextUnderImages);
    }

    @Step("assert that there is the iframe with “Frame Button” exist")
    public void testIsFrame() {
        assertThat(frame.isDisplayed()).isTrue();
    }

    @Step("switch to the {idFrame}")
    public void switchToFrame(String idFrame) {
        driver.switchTo().frame(idFrame);
    }

    @Step("check that there is button {buttonName} in the iframe")
    public void testFrameButton(String buttonAttribute, String buttonName) {
        String button = frameButton.getAttribute(buttonAttribute);
        assertThat(frameButton.isDisplayed()).isTrue();
        assertThat(button).isEqualTo(buttonName);
    }

    @Step("switch to original window back")
    public void switchToHomePage() {
        driver.switchTo().defaultContent();
    }

    @Step("check that there are {countSidebarMenuLeft} items in the Left Section "
        + "which are displayed and they have {expectedTextOnSidebarMenuLeft}")
    public void testSidebarMenuLeft(int countSidebarMenuLeft, List<String> expectedTextOnSidebarMenuLeft) {
        assertThat(sidebarMenuLeft).hasSize(countSidebarMenuLeft);
        List<String> textOnSidebarMenuLeft = sidebarMenuLeft.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textOnSidebarMenuLeft).isEqualTo(expectedTextOnSidebarMenuLeft);
    }
}
