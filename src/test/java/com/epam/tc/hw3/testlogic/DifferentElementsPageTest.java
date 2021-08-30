package com.epam.tc.hw3.testlogic;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.pages.BasePage;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.LoginPage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BasePage {

    @Test
    public void testDifferentElementsOnPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        //1. Open test site by URL
        loginPage.openSite();
        assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        //2. Assert Browser title "Home Page"
        assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //3. Perform login
        loginPage.performLogin();
        //4. Assert User name in the left-top side of screen is "ROMAN IOVLEV"
        WebElement webElement = webDriver.findElement(By.id("user-name"));
        assertThat(loginPage.getUsername()).isEqualTo("ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
        differentElementsPage.getHeaderMenu().click();
        differentElementsPage.getDifferentElement().click();
        //6. Select checkboxes "Water, Wind"
        differentElementsPage.getCheckBoxWater().click();
        differentElementsPage.getCheckBoxWind().click();
        //7. Select radio "Selen"
        differentElementsPage.getRadioSelen().click();
        //8. Select in dropdown "Yellow"
        Select color = new Select(differentElementsPage.getDropdownYellow());
        color.selectByVisibleText("Yellow");
        //9. Assert that checkbox, radio button, radio button names are corresponding to selected
        List<String> expectedContentInLogs = Arrays.asList("Yellow", "Selen", "Wind", "Water");
        List<String> textLogs = differentElementsPage.getLogs().stream().map(WebElement::getText)
            .collect(Collectors.toList());
        assertThat(textLogs).asString().containsSubsequence(expectedContentInLogs);
    }

}
