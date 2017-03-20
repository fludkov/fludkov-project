package com.github.fludkov.automation.edu.tests;

import com.github.fludkov.automation.edu.pages.AddToCartConfirmPage;
import com.github.fludkov.automation.edu.pages.HomePage;
import com.github.fludkov.automation.edu.pages.ProductDetailsPage;
import com.github.fludkov.automation.edu.pages.SearchResultsPage;
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

public class FirstTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Web Drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod () {
        homePage = new HomePage(driver).open();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddingItemToCard() throws InterruptedException {
        homePage.submitCity();
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Везде","jbl pulse 2");
        searchResultsPage.submitAdvertiseFrame();
        //Thread.sleep(99999);
        //Assert.assertTrue(searchResultsPage.getFirstResultTitle().contains("Apple iPhone"));
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();
        Assert.assertTrue(productDetailsPage.getProductTitle().contains("Apple iPhone"));
        AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();
        //Assert.assertEquals(productDetailsPage.getProductTitle(), "Защитное стекло Onext для Apple iPhone 4/4S");
        Thread.sleep(99999);
        /*

        String parentWindowHandle = driver.getWindowHandle();
        WebElement cityOkButton = driver.findElement(By.id("cityOk"));
        cityOkButton.click();
        WebElement searchField = driver.findElement(By.id("searchField"));
        searchField.sendKeys("Iphone 6s");
        WebElement mainSearchButton = driver.findElement(By.id("mainSearchButton"));
        mainSearchButton.click();


        driver.findElement(By.xpath("//a[@id=\"addToCart_btn\"]")).click();
        String bodyText2 = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText2.contains("Товар добавлен в корзину!"));
        assert
        */
    }

}
