package com.epam.tc.hw3.pages;

import java.util.List;
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

    public List<WebElement> getElementsOnHeaderSection() {
        return elementsOnHeaderSection;
    }

    public List<WebElement> getImagesOnPage() {
        return imagesOnPage;
    }

    public List<WebElement> getTextElementsUnderImages() {
        return textElementsUnderImages;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<WebElement> getSidebarMenuLeft() {
        return sidebarMenuLeft;
    }
}
