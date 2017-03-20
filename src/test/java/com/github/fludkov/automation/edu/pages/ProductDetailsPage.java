package com.github.fludkov.automation.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private static final By productTitleField = By.xpath("//h1");
    private static final By addToCartButton = By.id("addToCart_btn");
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitleField)
                .getText();
    }

    public AddToCartConfirmPage addToCart() {
        driver.findElement(addToCartButton)
                .click();
        return new AddToCartConfirmPage(driver);
    }

}