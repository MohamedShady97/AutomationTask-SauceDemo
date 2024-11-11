package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton= By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By OnesieProductDetails= By.id("item_2_title_link");
    private final By appLogo=By.className("app_logo");


    public ProductsPage clickOnAddToCart(){
        driver.findElement(addToCartButton).click();
        return this;
    }

    public OnesieProductPage clickOnOnesieProduct(){
        driver.findElement(OnesieProductDetails).click();
        return new OnesieProductPage(driver);
    }
    public boolean isAppLogoIsDisplayed(){
        return driver.findElement(appLogo).isDisplayed();
    }

    public void load(){
        driver.get("https://www.saucedemo.com/inventory.html");
    }

}
