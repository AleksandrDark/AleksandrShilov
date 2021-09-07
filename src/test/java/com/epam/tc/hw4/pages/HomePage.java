package com.epam.tc.hw4.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.util.DataProviderHelper;
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
    public void testElementsOnHeaderSection(DataProviderHelper dataHelper) {
        assertThat(elementsOnHeaderSection).hasSize(dataHelper.getCountElementsOnHeaderSection());
        List<String> actualTextListElements = elementsOnHeaderSection.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(actualTextListElements).isEqualTo(dataHelper.getExpectedTextListElements());
    }

    @Step("assert that there are 4 images on the Index Page and they are displayed")
    public void testCountImagesOnPage(DataProviderHelper dataHelper) {
        assertThat(imagesOnPage).hasSize(dataHelper.getCountImagesOnPage());
    }

    @Step("assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void testTextElementsUnderImages(DataProviderHelper dataHelper) {
        List<String> textListElementsUnderImages = textElementsUnderImages.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textListElementsUnderImages).isEqualTo(dataHelper.getExpectedTextUnderImages());
    }

    @Step("assert that there is the iframe with “Frame Button” exist")
    public void testIsFrame() {
        assertThat(frame.isDisplayed()).isTrue();
    }

    @Step("switch to the iframe")
    public void switchToFrame(DataProviderHelper dataHelper) {
        webDriver.switchTo().frame(dataHelper.getIdFrame());
    }

    @Step("check that there is “Frame Button” in the iframe")
    public void testFrameButton(DataProviderHelper dataHelper) {
        String button = frameButton.getAttribute(dataHelper.getButtonAttribute());
        assertThat(frameButton.isDisplayed()).isTrue();
        assertThat(button).isEqualTo(dataHelper.getButtonName());
    }

    @Step("switch to original window back")
    public void switchToHomePage() {
        webDriver.switchTo().defaultContent();
    }

    @Step("assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void testSidebarMenuLeft(DataProviderHelper dataHelper) {
        assertThat(sidebarMenuLeft).hasSize(dataHelper.getCountSidebarMenuLeft());
        List<String> textOnSidebarMenuLeft = sidebarMenuLeft.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textOnSidebarMenuLeft).isEqualTo(dataHelper.getExpectedTextOnSidebarMenuLeft());
    }
}
