package web_saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class for the Login page.
 * This class provides methods to interact with the login form and validate error messages.
 */
public class LoginPage extends BasePage {

    // Error message for locked-out users
    private static final String ERR_LOCKED_OUT = "Epic sadface: Sorry, this user has been locked out.";

    // Locators for login page elements
    private By txtUsername = By.id("user-name");  // Username input field
    private By txtPassword = By.id("password");   // Password input field
    private By btnLogin = By.id("login-button");  // Login button
    private By lblErrMsg = By.xpath("//div[contains(@class,'error-message-container')]/h3");  // Error message container

    /**
     * Constructor to initialize the LoginPage with the WebDriver instance.
     *
     * @param driver WebDriver instance used to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class
    }

    /**
     * Verifies if the user is currently on the login page by checking if the username field is displayed.
     *
     * @return true if the username field is displayed, false otherwise
     */
    public boolean isAt() {
        return driver.findElement(txtUsername).isDisplayed();
    }

    /**
     * Checks if the user has been locked out based on the displayed error message.
     *
     * @return true if the user is locked out, false otherwise
     */
    public boolean isUserLockedOut() {
        String error = driver.findElement(lblErrMsg).getText();
        return error.equals(ERR_LOCKED_OUT);  // Return true if the error matches the locked-out message
    }

    /**
     * Performs the login action by entering the provided username and password and clicking the login button.
     *
     * @param username The username to input
     * @param password The password to input
     */
    public void login(String username, String password) {
        // Enter the username
        driver.findElement(txtUsername).sendKeys(username);

        // Enter the password
        driver.findElement(txtPassword).sendKeys(password);

        // Click the login button
        driver.findElement(btnLogin).click();
    }
}
