package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    private WebDriver driver;

    // Locators
    private By pageTitle = By.className("title");
    private By sortDropdown = By.className("product_sort_container");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void sortProductsByPriceLowToHigh() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("lohi");
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}