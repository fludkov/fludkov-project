package com.github.fludkov.automation.edu.tests;

import com.github.fludkov.automation.edu.pages.*;
import com.github.fludkov.automation.edu.support.BaseTest;
import com.github.fludkov.automation.edu.support.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FirstTests extends BaseTest {

    /*
public Object[][] testData(Method method, String sheet) {

    System.out.println("222");
    ExcelReader excelReader = new ExcelReader();
    excelReader.setExcelFile(System.getProperty("user.dir") + "\\src\\test\\java\\com\\github\\fludkov\\automation\\edu\\support\\test data\\TestData.xlsx", sheet);
    List rowsNo = excelReader.getRowContains(method.getName(), 0);
    return excelReader.getTableArray(rowsNo);

}

public static void sdsds(List data) {
    System.out.println("333");
    System.out.println(data.get(0));
    System.out.println(data.get(1));
    System.out.println(data.get(2));
    System.out.println(data.get(3));
}
*/
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
