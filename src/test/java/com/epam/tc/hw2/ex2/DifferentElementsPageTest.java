package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw2.DriverInit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class DifferentElementsPageTest extends DriverInit {

    @Test
    public void testDifferentElementsOnPage() {
        //1. Open test site by URL
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(url);
        assertThat(url).isEqualTo(webDriver.getCurrentUrl());
        //2. Assert Browser title "Home Page"
        assertThat("Home Page").isEqualTo(webDriver.getTitle());
        //3. Perform login
        webDriver.findElement(By.cssSelector(".uui-profile-menu > a")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        //4. Assert User name in the left-top side of screen is "ROMAN IOVLEV"
        WebElement webElement = webDriver.findElement(By.id("user-name"));
        assertThat(webElement.getText()).isEqualTo("ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.xpath("//li[@class='menu-title']")).click();
        webDriver.findElement(By.linkText("Different elements")).click();
        //6. Select checkboxes "Water, Wind"
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input")).click();
        //7. Select radio "Selen"
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input")).click();
        //8. Select in dropdown "Yellow"
        Select color = new Select(webDriver.findElement(By.xpath("//select[@class='uui-form-element']")));
        color.selectByVisibleText("Yellow");
        //9. Assert that checkbox, radio button, radio button names are corresponding to selected
        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        List<String> expectedContentInLogs = Arrays.asList("Yellow", "Selen", "Wind", "Water");
        List<String> textLogs = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(textLogs).asString().containsSubsequence(expectedContentInLogs);
    }
}
