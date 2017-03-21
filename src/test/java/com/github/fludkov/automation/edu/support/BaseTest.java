package com.github.fludkov.automation.edu.support;

import com.github.fludkov.automation.edu.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {
    public WebDriver driver;
    private HomePage homePage;
    public static Logger logger;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        //Setting up logger
        Date date = new Date();
        String dateString = date.toString();
        String[] arr = dateString.split(" ");
        String logFileName = "log_" + arr[2] + arr[1] + arr[5] + "_" + System.currentTimeMillis() + ".txt";
        logger = Logger.getLogger("My log");
        FileHandler fh;
        try {
            fh = new FileHandler(System.getProperty("user.dir") + "\\src\\test\\java\\com\\github\\fludkov\\automation\\edu\\tests\\logs\\" + logFileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Setting up driver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Web Drivers\\chromedriver.exe");
        driver= new ChromeDriver();

        //Setting up timeouts
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod () {
        homePage = new HomePage(driver).open();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        //driver.close();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
