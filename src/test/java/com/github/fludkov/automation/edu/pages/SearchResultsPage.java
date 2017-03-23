package com.github.fludkov.automation.edu.pages;

//import com.github.fludkov.automation.edu.support.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final By searchResultItemTitle = By.xpath("//div[@id=\"catalogGoodsBlock\"]//div[@class=\"b-product__title\"]//a");
    private HomePage homePage;
    public SearchResultsPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getFirstResultTitle() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResultItemTitle));
        return driver.findElement(searchResultItemTitle)
                .getText();
    }

    public ProductDetailsPage clickFirstResultTitle() throws InterruptedException {
        //BaseTest.logger.info("Navigate to the details of the first found product");
        String parentWindowHandle = driver.getWindowHandle();
        WebElement searchResultemTitleWebElement = driver.findElement(searchResultItemTitle);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Actions actions = new Actions(driver);
        actions.moveToElement(searchResultemTitleWebElement).click().perform();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String handle : allWindowHandles)
        {
            System.out.println("!!!!!!!!!ALL WINDOW HANDLES ARE:" + handle);
            if (!handle.contains(parentWindowHandle)) {
                System.out.println("!!!!!!!!!WINDOW HANDLE1 IS:" + driver.getWindowHandle());
                driver.switchTo().window(handle);
                System.out.println("!!!!!!!!!WINDOW HANDLE2 IS:" + driver.getWindowHandle());
            }
        }
        return new ProductDetailsPage(driver);
    }

    public SearchResultsPage closeAdvertiseFrame() throws InterruptedException {
        try {
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"sp-fancybox-iframe\"]")));
            //BaseTest.logger.info("Close Advertise Frame");
            driver.findElement(By.xpath("//i[contains(@id, \"icon-close-button\")]")).click();
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            //BaseTest.logger.info("Advertise Frame is not displayed");
            }
        return this;
    }
}

