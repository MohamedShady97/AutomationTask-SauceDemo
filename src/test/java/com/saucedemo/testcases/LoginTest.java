package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @Test(description = "test the functionality of login")
    public void ShouldBeAbleToLoginWithUsernameAndPassword(){

        LoginPage loginPage = new LoginPage(driver);

        Boolean isLogoIsDisplayed= loginPage
                                    .load()
                                    .login("standard_user","secret_sauce")
                                    .isAppLogoIsDisplayed();

        Assert.assertTrue(isLogoIsDisplayed);

    }
}
/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean isAppLogoDisplayed= driver.findElement(By.className("app_logo")).isDisplayed();
        Assert.assertTrue(isAppLogoDisplayed);
        driver.quit();
*/