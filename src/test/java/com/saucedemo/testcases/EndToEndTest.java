package com.saucedemo.testcases;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EndToEndTest {


    public static void main (String[] args){

        // Set up driver and navigate to the website
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login using the standard user credentials on the login screen
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add sauce-labs-fleece-jacket to the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        // Add Sauce Labs Onesie to the the cart
        driver.findElement(By.id("item_2_title_link")).click();
        driver.findElement(By.id("add-to-cart")).click();

        // Assert the number of the products displayed on the cart icon
        String cartIconCount= driver.findElement(By.cssSelector("[data-test=\"shopping-cart-badge\"]")).getText();
        Assert.assertEquals(cartIconCount,"2");

        // Navigate to the cart page and verify the names and prices of the added products.
        driver.findElement(By.cssSelector("[data-test=\"shopping-cart-badge\"]")).click();
        // Find all the product elements on the cart page
        List<WebElement> products=driver.findElements(By.className("cart_list"));
        // Loop through each product to verify its name and price
        for(WebElement product : products){
            String productName = product.findElement(By.className("inventory_item_name")).getText();
            String productPrice = product.findElement(By.className("inventory_item_price")).getText();
            if (productName.equals("Sauce Labs Fleece Jacket"))
            {
                assert(productPrice.equals("$49.99"));
            }
            else if ((productName.equals("Sauce Labs Onesie"))){
                assert(productPrice.equals("$7.99"));
            }
            else System.out.println("No products");
        }

        //proceed to checkout
        driver.findElement(By.id("checkout")).click();

        // Entering user data
        driver.findElement(By.id("first-name")).sendKeys("mohamed");
        driver.findElement(By.id("last-name")).sendKeys("shady");
        driver.findElement(By.id("postal-code")).sendKeys("76547");
        driver.findElement(By.id("continue")).click();

        // Assert the order details on the overview page
        String overviewTitle= driver.findElement(By.className("title")).getText();
        Assert.assertEquals(overviewTitle,"Checkout: Overview");
        Assert.assertTrue(driver.findElement(By.className("summary_info_label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("summary_value_label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("summary_total_label")).isDisplayed());

        // Complete the purchase by clicking Finish
        driver.findElement(By.id("finish")).click();
        String completeTitle= driver.findElement(By.className("complete-header")).getText();
        assert(completeTitle.equals("Thank you for your order!"));

        driver.quit();
    }



}
