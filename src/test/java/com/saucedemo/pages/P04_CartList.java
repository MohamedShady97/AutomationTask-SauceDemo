package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class P04_CartList {

    protected WebDriver driver;
    private final By cartList= By.className("cart_list");
    private final By productName= By.className("inventory_item_name");
    private final By productPrice= By.className("inventory_item_price");
    private final By checkoutButton= By.id("checkout");

    public P04_CartList(WebDriver driver){
        this.driver=driver;
    }
    public List<WebElement>getCartList(){
        return driver.findElements(cartList);
    }

    public String getTextOfProductName(){
        return driver.findElement(productName).getText();
    }

    public String getTextOfProductPrice(){
        return driver.findElement(productPrice).getText();
    }

    public P05_CheckOutStepOne clickOnCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new P05_CheckOutStepOne(driver);
    }

    public P04_CartList load(){
        driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }

}
