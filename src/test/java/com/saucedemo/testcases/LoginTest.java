package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;

import com.saucedemo.pages.P01_LoginPage;
import com.saucedemo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(description = "test the functionality of login")
    public void ShouldBeAbleToLoginWithUsernameAndPassword(){

        P01_LoginPage p01LoginPage = new P01_LoginPage(driver);

        Boolean isLogoIsDisplayed= p01LoginPage
                                    .load()
                                    .login(ConfigUtils.getInstance().getUserName(),ConfigUtils.getInstance().getPassword())
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