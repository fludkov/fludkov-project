package com.github.fludkov.automation.edu.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Valerii_Fludkov on 3/19/2017.
 */
public class FirstTests {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class");
        //Commenting line below will result in an error
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Web Drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ulmart.ru/");
    }

    @BeforeMethod
    public void beforeMethod () {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod () {
        System.out.println("After Method");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After Class");
        driver.close();
        driver.quit();
    }

    @Test
    public void testAddingItemToCard() throws InterruptedException {
        System.out.println("TEST!!!111");
        String parentWindowHandle = driver.getWindowHandle();
        WebElement cityOkButton = driver.findElement(By.id("cityOk"));
        cityOkButton.click();
        WebElement searchField = driver.findElement(By.id("searchField"));
        searchField.sendKeys("Iphone 6s");
        WebElement mainSearchButton = driver.findElement(By.id("mainSearchButton"));
        mainSearchButton.click();
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Защитное стекло Prime для Apple iPhone 6/6S"));
        WebElement frame = driver.findElement(By.xpath("//iframe[@class=\"sp-fancybox-iframe\"]"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//i[contains(@id, \"icon-close-button\")]")).click();
        driver.switchTo().defaultContent();
        WebElement productLink = driver.findElement(By.xpath("//a[contains(text(), \"Защитное стекло Prime для Apple iPhone 6/6S\")]"));
        ////WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(productLink));
        Thread.sleep(1000);
        productLink.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String lastWindowHandle = "";
        for(String handle : allWindowHandles)
        {
            System.out.println(handle);
            if (!handle.contains(parentWindowHandle)) {
                driver.switchTo().window(handle);
            }
            ; //Switch to the desired window first and then execute commands using driver
            lastWindowHandle = handle;
        }
        driver.findElement(By.xpath("//a[@id=\"addToCart_btn\"]")).click();
        String bodyText2 = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText2.contains("Товар добавлен в корзину!"));
        assert
    }

}
