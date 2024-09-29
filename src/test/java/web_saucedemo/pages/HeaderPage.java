package web_saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_saucedemo.config.EnvironmentVariables;
import web_saucedemo.enums.AppMenu;

import java.time.Duration;

/**
 * Page Object Model class for the Header section of the application.
 * This class handles interactions with the elements present in the header
 * such as the navigation menu and the shopping cart.
 */
public class HeaderPage extends BasePage {

    // Locators for the header elements
    private By btnMenu = By.id("react-burger-menu-btn"); // Menu button (hamburger icon)
    private By navMenu = By.xpath("//nav[contains(@class, 'bm-item-list')]/a[contains(@class,'bm-item')]"); // Navigation menu items
    private By lblCart = By.id("shopping_cart_container"); // Shopping cart container

    /**
     * Constructor to initialize the HeaderPage with the WebDriver instance.
     *
     * @param driver WebDriver instance used to interact with the browser
     */
    public HeaderPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class
    }

    /**
     * Navigates to a specific item in the navigation menu by clicking the menu button,
     * waiting for the menu to be visible, and then selecting the desired option.
     *
     * @param menu Enum representing the menu item to navigate to
     * @return HeaderPage instance for method chaining
     */
    public HeaderPage navigateToMenu(AppMenu menu) {
        // Click on the menu button to open the navigation menu
        driver.findElement(btnMenu).click();

        // Wait until the menu items are clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvironmentVariables.WAIT_MAX));
        wait.until(ExpectedConditions.elementToBeClickable(navMenu));

        // Find the correct menu item based on the enum value
        WebElement btnMenu = driver.findElements(navMenu)
                .stream()
                .filter(element -> element.getText().equalsIgnoreCase(menu.value())) // Match the text with the enum value
                .findFirst() // Find the first matching element
                .orElseThrow(); // Throw an exception if no element is found

        // Click the found menu item
        btnMenu.click();

        // Return the current instance for method chaining
        return this;
    }

    /**
     * Retrieves the current count of items in the shopping cart.
     *
     * @return the number of items in the cart, or 0 if the cart is empty
     */
    public int getCartCount() {
        // Get the text from the shopping cart element
        String count = driver.findElement(lblCart).getText();

        // If the cart is empty, return 0; otherwise, parse the count as an integer
        return count.isEmpty() ? 0 : Integer.parseInt(count);
    }
}
