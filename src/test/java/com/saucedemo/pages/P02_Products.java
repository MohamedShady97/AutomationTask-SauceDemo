package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Products {

    private WebDriver driver;

    public P02_Products(WebDriver driver) {
        this.driver=driver;
    }

    private final By addToCartButton= By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By OnesieProductDetails= By.id("item_2_title_link");
    private final By appLogo=By.className("app_logo");


    public P02_Products clickOnAddToCart(){
        driver.findElement(addToCartButton).click();
        return this;
    }

    public P03_OnesieProductDetails clickOnOnesieProduct(){
        driver.findElement(OnesieProductDetails).click();
        return new P03_OnesieProductDetails(driver);
    }
    public boolean isAppLogoIsDisplayed(){
        return driver.findElement(appLogo).isDisplayed();
    }

    public void load(){
        driver.get("https://www.saucedemo.com/inventory.html");
    }

}
