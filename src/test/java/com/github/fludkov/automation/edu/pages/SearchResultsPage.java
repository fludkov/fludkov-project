package com.github.fludkov.automation.edu.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SearchResultsPage {
    private WebDriver driver;
    private static final By searchResultItemTitle = By.xpath("//div[@id=\"catalogGoodsBlock\"]//section[1]//div[@class=\"b-product__title\"]//a");
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
        for (int i = 0; i <1; i++) {
            try {
                System.out.println("!!!!!!!!!!!!!!!!!I=" + i);
                driver.switchTo().defaultContent();
                //driver.switchTo().frame(i);
                WebElement searchResultemTitleWebElement = driver.findElement(searchResultItemTitle);
                Actions actions = new Actions(driver);
                actions.moveToElement(searchResultemTitleWebElement);
                actions.perform();
                Thread.sleep(5000);
                searchResultemTitleWebElement.click();
            } catch (NoSuchElementException e) {System.out.println(e);}
        }
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
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class=\"sp-fancybox-iframe\"]")));
        driver.findElement(By.xpath("//i[contains(@id, \"icon-close-button\")]")).click();
        Thread.sleep(2000);
        return this;
    }
}

