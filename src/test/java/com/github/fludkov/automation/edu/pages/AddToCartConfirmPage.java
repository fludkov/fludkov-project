package com.github.fludkov.automation.edu.pages;

import com.github.fludkov.automation.edu.components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartConfirmPage {
    private static final By body = By.xpath("//div[@class=\"main-h1 main-h1_bold\"]");
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public AddToCartConfirmPage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public String getConfirmationText() {
        String confirmTextField = driver.findElement(body).getText();
        return confirmTextField;
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }
}
