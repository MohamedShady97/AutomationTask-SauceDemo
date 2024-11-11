package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePage {

    private final By pageHeader= By.className("complete-header");


    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

    public void load(){
        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }
}
