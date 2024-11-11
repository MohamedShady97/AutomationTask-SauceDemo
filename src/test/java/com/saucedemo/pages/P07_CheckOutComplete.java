package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_CheckOutComplete {
    private WebDriver driver;

    public P07_CheckOutComplete(WebDriver driver){
        this.driver=driver;
    }
    private final By pageHeader= By.className("complete-header");

    public String getTextOfPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

    public void load(){
        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }
}
