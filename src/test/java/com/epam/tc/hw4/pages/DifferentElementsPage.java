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
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends BasePage {
    @FindBy(css = "li.menu-title")
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
    @FindBy(css = ".panel-body-list > li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Step("Open the header menu Service")
    public void openServiceMenu() {
        headerMenu.click();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElement() {
        differentElement.click();
    }

    @Step("Select checkboxes \"Water\"")
    public void selectCheckBoxWater() {
        checkBoxWater.click();
    }

    @Step("Select checkboxes \"Wind\"")
    public void selectCheckBoxWind() {
        checkBoxWind.click();
    }

    @Step("Select radio \"Selen\"")
    public void selectRadioSelen() {
        radioSelen.click();
    }

    @Step("Select in dropdown \"Yellow\"")
    public void selectDropdownYellow(String color) {
        Select colorY = new Select(dropdownYellow);
        colorY.selectByVisibleText(color);
    }

    @Step("Assert that checkbox, radio button, radio button names are corresponding to selected")
    public void checkLogs(List<String> expectedContentInLogs) {
        List<String> textLogs = logs.stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textLogs).asString().containsSubsequence(expectedContentInLogs);
    }

}
