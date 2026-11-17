package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class SauceDemoE2ETest extends BaseTest {

    @Test(priority = 1, description = "Verify error message for invalid login credentials")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Username and password do not match"),
                "Expected error message was not displayed!");
    }

    @Test(priority = 2, description = "Verify successful login with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products",
                "User did not land on the Products page!");
    }

    @Test(priority = 3, description = "Verify product sorting and adding item to cart")
    public void testSortAndAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProductsByPriceLowToHigh();
        inventoryPage.addBackpackToCart();

        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1",
                "Cart badge count did not update to 1!");
    }

    @Test(priority = 4, description = "Verify end-to-end checkout and order confirmation flow")
    public void testEndToEndCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.enterShippingDetails("Himashi", "Kashmira", "91500");
        checkoutPage.clickFinish();

        Assert.assertEquals(checkoutPage.getOrderConfirmationText(), "Thank you for your order!",
                "Order confirmation message did not match!");
    }
}