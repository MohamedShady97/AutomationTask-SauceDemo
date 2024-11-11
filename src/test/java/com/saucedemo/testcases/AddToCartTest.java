package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.*;
import com.saucedemo.utils.ConfigUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends BaseTest {

@Test
    public void ShouldBeAbleToAddToCart() {

    P01_LoginPage p01LoginPage = new P01_LoginPage(driver);

    String numberOfProducts = p01LoginPage.load()
                            .login(ConfigUtils.getInstance().getUserName(),ConfigUtils.getInstance().getPassword())
                            .clickOnAddToCart()
                            .clickOnOnesieProduct()
                            .clickOnAddToCartButton()
                            .getNumberOfcartList();
    assert (numberOfProducts.equals("2"));

    P04_CartList p04CartList = new P04_CartList(driver);
    List<WebElement> products= p04CartList
                            .load()
                            .getCartList();

    for(WebElement product : products){
        String productName = p04CartList.getTextOfProductName();
        String productPrice = p04CartList.getTextOfProductPrice();
        if (productName.equals("Sauce Labs Fleece Jacket"))
        {
            assert(productPrice.equals("$49.99"));
        }
        else if ((productName.equals("Sauce Labs Onesie"))){
            assert(productPrice.equals("$7.99"));
        }
        else System.out.println("No products");
    }
    P06_CheckOutStepTwo p06CheckOutStepTwo = p04CartList
                            .clickOnCheckoutButton()
                            .enterUserData(ConfigUtils.getInstance().getFirstName(), ConfigUtils.getInstance().getLastName(), ConfigUtils.getInstance().getPostalCode())
                            .clickOnContinueButton();
    Assert.assertTrue(p06CheckOutStepTwo.isPageTitleDisplayed());
    Assert.assertTrue(p06CheckOutStepTwo.isSummaryInfoDisplayed());
    Assert.assertTrue(p06CheckOutStepTwo.isSummaryTotalDisplayed());

    P07_CheckOutComplete p07CheckOutCompletePage = new P07_CheckOutComplete(driver);
    String titleOfCompletePage= p06CheckOutStepTwo
                                .clickOnFinishButton()
                                .getTextOfPageHeader();
    Assert.assertEquals(titleOfCompletePage,"Thank you for your order!");

    }
}
