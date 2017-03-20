package com.github.fludkov.automation.edu.pages;

import com.github.fludkov.automation.edu.components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartConfirmPage {
    private static final By confirmTextField = By.xpath("confirm-text");
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public AddToCartConfirmPage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public String getConfirmationText() {
        return driver.findElement(confirmTextField)
                .getText();
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }
}
