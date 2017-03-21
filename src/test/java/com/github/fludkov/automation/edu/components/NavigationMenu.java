package com.github.fludkov.automation.edu.components;

import com.github.fludkov.automation.edu.pages.CartPage;
import com.github.fludkov.automation.edu.pages.SearchResultsPage;
import com.github.fludkov.automation.edu.support.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMenu {

    private static final By searchField = By.id("searchField");
    private static final By mainSearchButton = By.id("mainSearchButton");
    private static final By categoryButton = By.id("search-cat-b");
    private static final By categoryMenu = By.xpath("//ul[@id=\"search-cat-menu\"]");
    private WebDriver driver;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage searchFor(String category, String searchKey) throws InterruptedException {
        BaseTest.logger.info(String.format("Search for the '%s' in the category: '%s'", category, searchKey));
        driver.findElement(categoryButton).click();
        WebElement categoryWebElement = driver.findElement(categoryMenu).findElement(By.xpath("//a[contains(text(), \"" + category + "\")]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(categoryWebElement));
        categoryWebElement.click();
        driver.findElement(searchField).sendKeys(searchKey);
        driver.findElement(mainSearchButton).click();
        return new SearchResultsPage(driver);
    }

    public CartPage navigateToCartPage() {
        BaseTest.logger.info("Navigate to the cart page");
        driver.findElement(searchField)
                .click();
        return new CartPage(driver);
    }




}