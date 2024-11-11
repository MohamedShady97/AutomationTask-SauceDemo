package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage extends BasePage {

    private final By pageTitle= By.className("title");
    private final By summaryInfo= By.className("summary_info_label");
    private final By summaryValue= By.className("summary_value_label");
    private final By summaryTotal= By.className("summary_total_label");
    private final By finishButton= By.id("finish");

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
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
    public CheckOutCompletePage clickOnFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckOutCompletePage(driver);
    }
    public void load(){
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }
}
