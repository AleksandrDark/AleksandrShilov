package com.epam.tc.hw2.ex2;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class DifferentElementsPageTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testDifferentElementsOnPage() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(url);
        assertEquals(url, webDriver.getCurrentUrl());
        assertEquals("Home Page", webDriver.getTitle());
        webDriver.findElement(By.xpath("//a[@href='#']")).click();
        webDriver.findElement(By.xpath("//*[@id='name']")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id='user-name']"));
        assertEquals(webElement.getText(), "ROMAN IOVLEV");
        webDriver.findElement(By.xpath("//li[@class='menu-title']")).click();
        webDriver.findElement(By.linkText("Different elements")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input")).click();
        Select color = new Select(webDriver.findElement(By.xpath("//select[@class='uui-form-element']")));
        color.selectByVisibleText("Yellow");
        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        List<String> yellow = Arrays.asList(elements.get(0).getText().split(" "));
        assertTrue(yellow.contains("Yellow"));
        List<String> selen = Arrays.asList(elements.get(1).getText().split(" "));
        assertTrue(selen.contains("Selen"));
        List<String> wind = Arrays.asList(elements.get(2).getText().split("\\s|\\W"));
        assertTrue(wind.contains("Wind"));
        List<String> water = Arrays.asList(elements.get(3).getText().split("\\s|\\W"));
        assertTrue(water.contains("Water"));
    }

    @AfterMethod
    public void clear() {
        webDriver.close();
    }
}
