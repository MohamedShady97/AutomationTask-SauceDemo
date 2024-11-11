package com.saucedemo.pages;

import com.saucedemo.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    protected WebDriver driver;
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public P01_LoginPage(WebDriver driver) {
        this.driver=driver;
    }


    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public P02_Products login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new P02_Products(driver);
    }

    public P01_LoginPage load (){

        driver.get(ConfigUtils.getInstance().getbaseUrl());
        return this;

    }
}
