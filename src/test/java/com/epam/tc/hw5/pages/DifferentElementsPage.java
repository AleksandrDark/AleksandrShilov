package com.epam.tc.hw5.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends BasePage {

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
    @FindBy(css = ".panel-body-list > li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openDifferentElement() {
        differentElement.click();
    }

    public void selectCheckBoxWater() {
        checkBoxWater.click();
    }

    public void selectCheckBoxWind() {
        checkBoxWind.click();
    }

    public void selectRadioSelen() {
        radioSelen.click();
    }

    public void selectDropdownYellow(String color) {
        Select colorY = new Select(dropdownYellow);
        colorY.selectByVisibleText(color);
    }

    public void checkLogs(List<String> expectedContentInLogs) {
        List<String> textLogs = logs.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textLogs).asString().containsSubsequence(expectedContentInLogs);
    }

}
