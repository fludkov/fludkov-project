package com.github.fludkov.automation.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.fludkov.automation.edu.components.NavigationMenu;
import org.openqa.selenium.WebElement;

public class HomePage{
    private static final String pageUrl = "http://www.ulmart.ru";
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open() {
        driver.get(pageUrl);
        return this;
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }
}




