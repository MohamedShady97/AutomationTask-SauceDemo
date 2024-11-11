package com.saucedemo.base;

import com.saucedemo.factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
