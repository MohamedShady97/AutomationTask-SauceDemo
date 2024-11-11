package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends BaseTest {

@Test
    public void ShouldBeAbleToAddToCart() {

    LoginPage loginPage = new LoginPage(driver);

    String numberOfProducts =
            loginPage.load()
                    .login("standard_user", "secret_sauce")
                    .clickOnAddToCart()
                    .clickOnOnesieProduct()
                    .clickOnAddToCartButton()
                    .getNumberOfcartList();
    assert (numberOfProducts.equals("2"));

    CartListPage cartListPage= new CartListPage(driver);
    List<WebElement> products=cartListPage
                            .load()
                            .getCartList();

    for(WebElement product : products){
        String productName = cartListPage.getTextOfProductName();
        String productPrice = cartListPage.getTextOfProductPrice();
        if (productName.equals("Sauce Labs Fleece Jacket"))
        {
            assert(productPrice.equals("$49.99"));
        }
        else if ((productName.equals("Sauce Labs Onesie"))){
            assert(productPrice.equals("$7.99"));
        }
        else System.out.println("No products");
    }
    CheckOutStepTwoPage checkOutStepTwoPage =
                                     cartListPage
                                    .clickOnCheckoutButton()
                                    .enterUserData("mohamed","shady","87943")
                                    .clickOnContinueButton();
    Assert.assertTrue(checkOutStepTwoPage.isPageTitleDisplayed());
    Assert.assertTrue(checkOutStepTwoPage.isSummaryInfoDisplayed());
    Assert.assertTrue(checkOutStepTwoPage.isSummaryTotalDisplayed());

    CheckOutCompletePage checkOutCompletePage= new CheckOutCompletePage(driver);
    String titleOfCompletePage= checkOutStepTwoPage
                                .clickOnFinishButton()
                                .getTextOfPageHeader();
    Assert.assertEquals(titleOfCompletePage,"Thank you for your order!");

    }
}
