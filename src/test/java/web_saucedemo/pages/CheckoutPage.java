package web_saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web_saucedemo.contexts.CheckoutYourInfoData;

/**
 * Page Object Model class for the Checkout page.
 * This class provides methods to interact with the elements on the Checkout page
 * such as filling in user information and completing the checkout process.
 */
public class CheckoutPage extends BasePage {

    // Locators for the elements on the Checkout page
    private By txtFName = By.id("first-name"); // First Name input field
    private By txtLName = By.id("last-name");  // Last Name input field
    private By txtZip = By.id("postal-code");  // Postal Code input field
    private By btnContinue = By.id("continue"); // Continue button
    private By btnFinish = By.id("finish");     // Finish button

    /**
     * Constructor to initialize the CheckoutPage with the WebDriver instance.
     *
     * @param driver WebDriver instance used to interact with the browser
     */
    protected CheckoutPage(WebDriver driver) {
        super(driver); // Calling the constructor of the BasePage class
    }

    /**
     * Checks if the checkout process is complete by verifying the presence
     * of the checkout complete container.
     *
     * @return true if checkout is complete, otherwise false
     */
    public boolean isCheckoutComplete() {
        return driver.findElement(By.id("checkout_complete_container")).isDisplayed();
    }

    /**
     * Fills in the user's checkout information (first name, last name, and postal code)
     * and clicks the Continue button.
     *
     * @param data CheckoutYourInfoData object containing the user's info
     * @return CheckoutPage instance for method chaining
     */
    public CheckoutPage setInformation(CheckoutYourInfoData data) {
        driver.findElement(txtFName).sendKeys(data.getFirstName()); // Enter first name
        driver.findElement(txtLName).sendKeys(data.getLastName());  // Enter last name
        driver.findElement(txtZip).sendKeys(data.getZip());         // Enter postal code
        driver.findElement(btnContinue).click();                   // Click the Continue button
        return this; // Return the current CheckoutPage instance for method chaining
    }

    /**
     * Completes the checkout process by clicking the Finish button.
     *
     * @return CheckoutPage instance for method chaining
     */
    public CheckoutPage finish() {
        driver.findElement(btnFinish).click(); // Click the Finish button
        return this; // Return the current CheckoutPage instance for method chaining
    }
}
