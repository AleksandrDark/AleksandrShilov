package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class HomePageTest {

    private WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testHomePage() {
        driver = new ChromeDriver();
        SoftAssertions softAssertions = new SoftAssertions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.navigate().to(url);
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(url);
        softAssertions.assertThat(driver.getTitle()).isEqualTo("Home Page");
        driver.findElement(By.xpath("/html/body/header/div/nav/ul[2]/li/a")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        WebElement webElement = driver.findElement(By.xpath("//*[@id='user-name']"));
        softAssertions.assertThat(webElement.getText()).isEqualTo("ROMAN IOVLEV");
        webElement = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[1]/a"));
        softAssertions.assertThat(webElement.getText()).isEqualTo("HOME");
        webElement = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[2]/a"));
        softAssertions.assertThat(webElement.getText()).isEqualTo("CONTACT FORM");
        webElement = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/a"));
        softAssertions.assertThat(webElement.getText()).isEqualTo("SERVICE");
        webElement = driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[4]/a"));
        softAssertions.assertThat(webElement.getText()).isEqualTo("METALS & COLORS");
        List<WebElement> imagesOnPage = driver.findElements(By.cssSelector(".benefit-icon"));
        softAssertions.assertThat(imagesOnPage.size()).isEqualTo(4);
        List<WebElement> textUnderImages = driver.findElements(By.cssSelector(".benefit-txt"));
        String firstTextUnderImage = "To include good practices\nand ideas from successful\nEPAM project";
        softAssertions.assertThat(textUnderImages.get(0).getText()).isEqualTo(firstTextUnderImage);
        String secondTextUnderImage = "To be flexible and\ncustomizable";
        softAssertions.assertThat(textUnderImages.get(1).getText()).isEqualTo(secondTextUnderImage);
        String thirdTextUnderImage = "To be multiplatform";
        softAssertions.assertThat(textUnderImages.get(2).getText()).isEqualTo(thirdTextUnderImage);
        String fourthTextUnderImage = "Already have good base\n(about 20 internal and\nsome external projects),"
            + "\nwish to get more…";
        softAssertions.assertThat(textUnderImages.get(3).getText()).isEqualTo(fourthTextUnderImage);

        final String windowHandler = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        String button = driver.findElement(By.id("frame-button")).getAttribute("value");
        softAssertions.assertThat(button).isEqualTo("Frame Button");
        driver.switchTo().window(windowHandler);
        List<WebElement> sidebarMenuLeft =
            driver.findElements(By.xpath("//ul[contains(@class, 'sidebar-menu left')]/li/a"));
        softAssertions.assertThat(sidebarMenuLeft.size()).isEqualTo(5);
        softAssertions.assertThat(sidebarMenuLeft.get(0).getText()).isEqualTo("Home");
        softAssertions.assertThat(sidebarMenuLeft.get(1).getText()).isEqualTo("Contact form");
        softAssertions.assertThat(sidebarMenuLeft.get(2).getText()).isEqualTo("Service");
        softAssertions.assertThat(sidebarMenuLeft.get(3).getText()).isEqualTo("Metals & Colors");
        softAssertions.assertThat(sidebarMenuLeft.get(4).getText()).isEqualTo("Elements packs");
        softAssertions.assertAll();
    }

    @AfterMethod
    public void clear() {
        driver.close();
    }

}
