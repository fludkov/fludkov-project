package com.github.fludkov.automation.edu.pages;

import com.github.fludkov.automation.edu.support.BaseTest;
import org.openqa.selenium.*;
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
        return driver.findElement(searchResultItemTitle)
                .getText();
    }

    public ProductDetailsPage clickFirstResultTitle() throws InterruptedException {
        BaseTest.logger.info("Navigate to the details of the first found product");
        String parentWindowHandle = driver.getWindowHandle();
        WebElement searchResultemTitleWebElement = driver.findElement(searchResultItemTitle);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(searchResultemTitleWebElement));
        searchResultemTitleWebElement.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String handle : allWindowHandles)
        {
            if (!handle.contains(parentWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }
        return new ProductDetailsPage(driver);
    }

    public SearchResultsPage closeAdvertiseFrame() throws InterruptedException {
        BaseTest.logger.info("Close Advertise Frame");
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class=\"sp-fancybox-iframe\"]")));
        driver.findElement(By.xpath("//i[contains(@id, \"icon-close-button\")]")).click();
        Thread.sleep(2000);
        return this;
    }
}

