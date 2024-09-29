package web_saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Page Object Model class for the Products page.
 * This class provides methods to interact with product sorting, adding, and removing items from the cart.
 */
public class ProductsPage extends BasePage {

    // Locators for product page elements
    private By drpSort = By.xpath("//select[@data-test='product_sort_container']"); // Dropdown for sorting products
    private By lstProduct = By.xpath("//div[contains(@class,'inventory_list')]/div"); // List of all product elements
    private By lstProduct_title = By.xpath(".//a[contains(@id,'title_link')]"); // Product title within a product element
    private By lstProduct_add = By.xpath(".//button[contains(@class,'btn_inventory')][contains(@id,'add-to-cart')]"); // Add-to-cart button
    private By lstProduct_remove = By.xpath(".//button[contains(@class,'btn_inventory')][contains(@id,'remove')]"); // Remove-from-cart button

    /**
     * Constructor to initialize the ProductsPage with the WebDriver instance.
     *
     * @param driver WebDriver instance used to interact with the browser
     */
    public ProductsPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class
    }

    /**
     * Private helper method to get the WebElement representing a product based on the product title.
     *
     * @param title The title of the product to find
     * @return The WebElement representing the product
     */
    private WebElement getProduct(String title) {
        // Find the list of product elements, then filter the one matching the provided title
        return driver.findElements(lstProduct)
                .stream()
                .filter(element -> element.findElement(lstProduct_title).getText().equals(title)) // Match product by title
                .findFirst()
                .orElseThrow(); // Throw an exception if the product is not found
    }

    /**
     * Sorts the products by the given option from the dropdown.
     *
     * @param orderBy The visible text to sort by (e.g., "Name (A to Z)", "Price (low to high)")
     * @return ProductsPage instance for method chaining
     */
    public ProductsPage sort(String orderBy) {
        // Find the sort dropdown and select the specified sort order
        WebElement dropdown = driver.findElement(drpSort);
        Select select = new Select(dropdown);
        select.selectByVisibleText(orderBy);
        return this; // Return the current instance for method chaining
    }

    /**
     * Adds the product with the specified title to the cart.
     *
     * @param title The title of the product to add
     * @return ProductsPage instance for method chaining
     */
    public ProductsPage add(String title) {
        // Find the product and click the add-to-cart button
        getProduct(title).findElement(lstProduct_add).click();
        return this; // Return the current instance for method chaining
    }

    /**
     * Removes the product with the specified title from the cart.
     *
     * @param title The title of the product to remove
     * @return ProductsPage instance for method chaining
     */
    public ProductsPage remove(String title) {
        // Find the product and click the remove-from-cart button
        getProduct(title).findElement(lstProduct_remove).click();
        return this; // Return the current instance for method chaining
    }
}
