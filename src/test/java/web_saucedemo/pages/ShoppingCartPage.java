package web_saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object Model class for the Shopping Cart page.
 * This class provides methods to interact with the shopping cart, check products,
 * and proceed to checkout.
 */
public class ShoppingCartPage extends BasePage {

    // Locators for the shopping cart elements
    private By lstProduct = By.xpath("//div[contains(@class,'cart_list')]/div[contains(@class,'cart_item')]"); // List of products in the cart
    private By lstProduct_title = By.xpath(".//a[contains(@id,'title_link')]"); // Product title within a cart item
    private By btnCart = By.id("shopping_cart_container"); // Shopping cart button

    /**
     * Constructor to initialize the ShoppingCartPage with the WebDriver instance.
     *
     * @param driver WebDriver instance used to interact with the browser
     */
    public ShoppingCartPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class
    }

    /**
     * Private helper method to find a product by its title in the shopping cart.
     *
     * @param title The title of the product to find
     * @return The WebElement representing the product
     */
    private WebElement getProduct(String title) {
        // Find the list of products, then filter by the provided product title
        return driver.findElements(lstProduct)
                .stream()
                .filter(element -> element.findElement(lstProduct_title).getText().equals(title)) // Match product by title
                .findFirst()
                .orElseThrow(); // Throw an exception if the product is not found
    }

    /**
     * Checks if a product with the specified title is present in the shopping cart.
     *
     * @param title The title of the product to check
     * @return true if the product is in the cart, false otherwise
     */
    public boolean isProductInCart(String title) {
        return getProduct(title).isDisplayed(); // Check if the product is displayed
    }

    /**
     * Opens the shopping cart by clicking the cart button.
     *
     * @return ShoppingCartPage instance for method chaining
     */
    public ShoppingCartPage open() {
        // Click the shopping cart icon to open the cart
        driver.findElement(btnCart).click();
        return this; // Return the current instance for method chaining
    }

    /**
     * Proceeds to the checkout page by clicking the checkout button.
     *
     * @return A new instance of the CheckoutPage
     */
    public CheckoutPage checkout() {
        // Click the checkout button to proceed
        driver.findElement(By.id("checkout")).click();
        return new CheckoutPage(driver); // Return a new instance of CheckoutPage
    }
}
