package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_OnesieProductDetails {

    private WebDriver driver;

    private final By addToCartButton= By.id("add-to-cart");
    private final By shoppingCartBadge= By.cssSelector("[data-test=\"shopping-cart-badge\"]");

    public P03_OnesieProductDetails(WebDriver driver) {
        this.driver=driver;
    }
    public P03_OnesieProductDetails clickOnAddToCartButton(){
        driver.findElement(addToCartButton).click();
        return this;
    }
    public P04_CartList clickOnShoppingCartBadge(){
        driver.findElement(shoppingCartBadge).click();
        return new P04_CartList(driver);
    }
    public String getNumberOfcartList(){
        return driver.findElement(shoppingCartBadge).getText();
    }

    public void load(){
        driver.get("https://www.saucedemo.com/inventory-item.html?id=2");
    }
}
