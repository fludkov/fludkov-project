package com.github.fludkov.automation.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private static final By listItem = By.className("a-list-item");
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstItemText() {

        return driver.findElement(listItem)
                .getText();

    }
}
