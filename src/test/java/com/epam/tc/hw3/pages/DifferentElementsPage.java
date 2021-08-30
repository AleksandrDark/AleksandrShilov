package com.epam.tc.hw3.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends BasePage {
    @FindBy(xpath = "//li[@class='menu-title']")
    private WebElement headerMenu;
    @FindBy(linkText = "Different elements")
    private WebElement differentElement;
    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement checkBoxWater;
    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement checkBoxWind;
    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement radioSelen;
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdownYellow;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getHeaderMenu() {
        return headerMenu;
    }

    public WebElement getDifferentElement() {
        return differentElement;
    }

    public WebElement getCheckBoxWater() {
        return checkBoxWater;
    }

    public WebElement getCheckBoxWind() {
        return checkBoxWind;
    }

    public WebElement getRadioSelen() {
        return radioSelen;
    }

    public WebElement getDropdownYellow() {
        return dropdownYellow;
    }

    public List<WebElement> getLogs() {
        return logs;
    }

}
