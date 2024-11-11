package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CheckOutStepOne {

    private WebDriver driver;

    By firstNameInput= By.id("first-name");
    By lastNameInput= By.id("last-name");
    By postalCodeInput= By.id("postal-code");
    By continueButton= By.id("continue");

    public P05_CheckOutStepOne(WebDriver driver){
        this.driver=driver;
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
    public P06_CheckOutStepTwo clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new P06_CheckOutStepTwo(driver);
    }
    public P05_CheckOutStepOne enterUserData(String fName, String LName, String postalCode){
        enterFirstName(fName);
        enterLastName(LName);
        enterPostalCode(postalCode);
        return this;
    }

    public void load(){
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

}
