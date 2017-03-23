package com.github.fludkov.automation.edu.tests;

import com.github.fludkov.automation.edu.pages.*;
import com.github.fludkov.automation.edu.support.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTests extends BaseTest{


    @Test(groups = { "Cart Page" })
    public void testAddingItemToCart1() throws InterruptedException {
        System.out.println("This is testAddingItemToCart1 for Cart Page group");
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

    @Test(groups = { "Cart Page" }, dependsOnMethods = "testAddingItemToCart1")
    public void testItemIsInCart1() throws InterruptedException {
        System.out.println("This is testItemIsInCart1 for Cart Page group");
        HomePage homePage = new HomePage(this.driver);
        homePage.submitCity();
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Везде","Iphone 6");
        searchResultsPage.closeAdvertiseFrame();
        Assert.assertTrue(searchResultsPage.getFirstResultTitle().contains("Apple iPhone"));
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();
        Assert.assertTrue(productDetailsPage.getProductTitle().contains("Apple iPhone"));
        productDetailsPage.goToCart();
    }

    @Test(groups = { "Home Page" })
    public void testHomePage1() {
        System.out.println("This is testHomePage1 for Home Page group");
        HomePage homePage = new HomePage(this.driver);
    }

    @Test(groups = { "Home Page" })
    public void testHomePage2() {
        System.out.println("This is testHomePage2 for Home Page group");
        HomePage homePage = new HomePage(this.driver);
    }

    @Test(groups = { "Home Page", "Product Page" })
    public void testHomeProductPage() throws InterruptedException {
        System.out.println("This is testProductPage for  Home AND Product Pages");
    }

}
