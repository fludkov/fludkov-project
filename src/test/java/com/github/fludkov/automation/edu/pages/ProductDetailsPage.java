package com.github.fludkov.automation.edu.pages;

import com.github.fludkov.automation.edu.support.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private static final By productTitleField = By.xpath("//h1");
    private static final By addToCartButton = By.id("addToCart_btn");
    private static final By goToCartButton = By.xpath("//a[contains(text(), 'В корзине')]");
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitleField)
                .getText();
    }

    public AddToCartConfirmPage addToCart() {
        BaseTest.logger.info("Add item to cart");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton)
                .click();
        return new AddToCartConfirmPage(driver);
    }

    public CartPage goToCart() {
        BaseTest.logger.info("Go to the cart from product page item to cart");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        driver.findElement(goToCartButton)
                .click();
        return new CartPage(driver);
    }

}