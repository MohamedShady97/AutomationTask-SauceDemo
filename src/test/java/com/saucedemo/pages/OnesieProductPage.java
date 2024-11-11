package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnesieProductPage extends BasePage {

    private final By addToCartButton= By.id("add-to-cart");
    private final By shoppingCartBadge= By.cssSelector("[data-test=\"shopping-cart-badge\"]");


    public OnesieProductPage(WebDriver driver) {
        super(driver);
    }

    public OnesieProductPage clickOnAddToCartButton(){
        driver.findElement(addToCartButton).click();
        return this;
    }
    public CartListPage clickOnShoppingCartBadge(){
        driver.findElement(shoppingCartBadge).click();
        return new CartListPage(driver);
    }
    public String getNumberOfcartList(){
        return driver.findElement(shoppingCartBadge).getText();
    }

    public void load(){
        driver.get("https://www.saucedemo.com/inventory-item.html?id=2");
    }
}
