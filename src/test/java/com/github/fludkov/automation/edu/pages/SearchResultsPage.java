package com.github.fludkov.automation.edu.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SearchResultsPage {
    private WebDriver driver;
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
        String parentWindowHandle = driver.getWindowHandle();
        WebElement searchResultemTitleWebElement = driver.findElement(searchResultItemTitle);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + searchResultemTitleWebElement.getLocation().y + ")");
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

    public SearchResultsPage submitAdvertiseFrame() throws InterruptedException {
        WebElement frame = driver.findElement(By.xpath("//iframe[@class=\"sp-fancybox-iframe\"]"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//i[contains(@id, \"icon-close-button\")]")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        return this;
    }
}

