package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_CheckOutStepTwo {

    private WebDriver driver;

    private final By pageTitle= By.className("title");
    private final By summaryInfo= By.className("summary_info_label");
    private final By summaryValue= By.className("summary_value_label");
    private final By summaryTotal= By.className("summary_total_label");
    private final By finishButton= By.id("finish");

    public P06_CheckOutStepTwo(WebDriver driver){
        this.driver=driver;
    }

    public boolean isPageTitleDisplayed(){
        return driver.findElement(pageTitle).isDisplayed();
    }
    public boolean isSummaryInfoDisplayed(){
        return driver.findElement(summaryInfo).isDisplayed();
    }
    public boolean isSummaryValueDisplayed(){
        return driver.findElement(summaryValue).isDisplayed();
    }
    public boolean isSummaryTotalDisplayed(){
        return driver.findElement(summaryTotal).isDisplayed();
    }
    public P07_CheckOutComplete clickOnFinishButton(){
        driver.findElement(finishButton).click();
        return new P07_CheckOutComplete(driver);
    }
    public void load(){
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }
}
