package com.github.fludkov.automation.edu.components;

import com.github.fludkov.automation.edu.pages.SearchResultsPage;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenu {
    private static final By cityOkButton = By.id("cityOk");
    private static final By searchField = By.id("searchField");
    private static final By mainSearchButton = By.id("mainSearchButton");
    private static final By categoryButton = By.id("search-cat-b");
    private static final By categoryMenu = By.xpath(//ul[@id="search-cat-menu"]//a[contains(text(), "Везде")]);

    private WebDriver driver;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage searchFor(String category, String searchKey) {
        driver.findElement(categoryButton)
                .click();
        driver.findElement(categoryMenu)
                .click();
        return new SearchResultsPage(driver);
    }

}

}
