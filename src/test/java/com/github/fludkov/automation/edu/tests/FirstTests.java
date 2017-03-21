package com.github.fludkov.automation.edu.tests;

import com.github.fludkov.automation.edu.pages.AddToCartConfirmPage;
import com.github.fludkov.automation.edu.pages.HomePage;
import com.github.fludkov.automation.edu.pages.ProductDetailsPage;
import com.github.fludkov.automation.edu.pages.SearchResultsPage;
import com.github.fludkov.automation.edu.support.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FirstTests extends BaseTest {

    @Test
    public void testAddingItemToCard() throws InterruptedException {
        HomePage homePage = new HomePage(this.driver);
        homePage.submitCity();
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Везде","Iphone 6");
        searchResultsPage.closeAdvertiseFrame();
        Assert.assertTrue(searchResultsPage.getFirstResultTitle().contains("Apple iPhone"));
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();
        Assert.assertTrue(productDetailsPage.getProductTitle().contains("Apple iPhone"));
        AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();
        Assert.assertEquals(addToCartConfirmPage.getConfirmationText(), "Товар добавлен в корзину!");
    }
}
