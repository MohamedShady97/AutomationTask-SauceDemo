package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage {

    By firstNameInput= By.id("first-name");
    By lastNameInput= By.id("last-name");
    By postalCodeInput= By.id("postal-code");
    By continueButton= By.id("continue");

    public CheckOutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void enterPostalCode(String postalCode){
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }
    public CheckOutStepTwoPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckOutStepTwoPage(driver);
    }
    public CheckOutStepOnePage enterUserData(String fName,String LName,String postalCode){
        enterFirstName(fName);
        enterLastName(LName);
        enterPostalCode(postalCode);
        return this;
    }

    public void load(){
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

}
