package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartListPage extends BasePage {

    private final By cartList= By.className("cart_list");
    private final By productName= By.className("inventory_item_name");
    private final By productPrice= By.className("inventory_item_price");
    private final By checkoutButton= By.id("checkout");


    public CartListPage(WebDriver driver) {
        super(driver);
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

    public CheckOutStepOnePage clickOnCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new CheckOutStepOnePage(driver);
    }

    public CartListPage load(){
        driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }

}
