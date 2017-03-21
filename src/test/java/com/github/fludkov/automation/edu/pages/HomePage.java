package com.github.fludkov.automation.edu.pages;

import com.github.fludkov.automation.edu.support.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.fludkov.automation.edu.components.NavigationMenu;

public class HomePage{
    private static final String pageUrl = "https://www.ulmart.ru";
    private static final By cityOkButton = By.id("cityOk");
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open() {
        BaseTest.logger.info("Open url page: " + pageUrl);
        driver.get(pageUrl);
        driver.manage().window().maximize();
        return this;
    }

    public HomePage submitCity() {
        BaseTest.logger.info("Confrim that your pre-selected city is ok");
        if (driver.findElements( cityOkButton ).size() != 0) {
        driver.findElement(cityOkButton).click();}
        return this;
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }
}