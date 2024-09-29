# SauceDemo Automation Test Suite

This project is an automated test suite for testing key functionalities of the SauceDemo web application. It is built using Selenium WebDriver for browser automation and JUnit 5 for testing purposes.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Use Cases](#use-cases)
   - [Use Case 1: Login with Valid Credentials](#use-case-1-login-with-valid-credentials)
   - [Use Case 2: Handle Locked-Out User Error](#use-case-2-handle-locked-out-user-error)
   - [Use Case 3: Add a Product to the Cart](#use-case-3-add-a-product-to-the-cart)
   - [Use Case 4: Complete the Checkout Process](#use-case-4-complete-the-checkout-process)
4. [Running the Tests](#running-the-tests)

## Project Overview

This suite is designed to validate key functionalities such as user login, product browsing, adding items to the shopping cart, and completing the checkout process on the SauceDemo web application. It helps ensure that these core features work as expected, enhancing the reliability of the web application.

## Technologies Used

- **Java**: The core programming language for the project.
- **Selenium WebDriver**: Used for browser automation and interaction with web elements.
- **JUnit 5**: A testing framework for writing and executing test cases.
- **Maven**: A build automation tool that manages project dependencies and test execution.

## Use Cases

### Use Case 1: Login with Valid Credentials

**Primary Actor**: Registered user

**Preconditions**:

- The user has valid credentials (username and password).

**Trigger**:

- The user enters valid login details and clicks the "Login" button.

**Basic Flow**:

1. The user navigates to the SauceDemo login page.
2. The user enters their valid username and password.
3. The user clicks the "Login" button.
4. The system authenticates the user and redirects them to the Products page.
5. The system displays the list of available products.

**Postconditions**:

- The user is successfully logged in and can view the product list.

**Exceptions**:

- If invalid credentials are provided, an error message is displayed, and login is denied.

---

### Use Case 2: Handle Locked-Out User Error

**Primary Actor**: Locked-out user

**Preconditions**:

- The user is locked out from logging into the system.

**Trigger**:

- The user attempts to log in with valid credentials but is locked out.

**Basic Flow**:

1. The user navigates to the login page.
2. The user enters valid but locked-out credentials.
3. The user submits the login form.
4. The system checks the user’s status and identifies that the user is locked out.
5. The system displays an error message: "Epic sadface: Sorry, this user has been locked out."

**Postconditions**:

- The login fails, and the user sees the locked-out error message.

**Exceptions**:

- If the user is not locked out, they are redirected to the product page as usual.

---

### Use Case 3: Add a Product to the Cart

**Primary Actor**: Logged-in user

**Preconditions**:

- The user is logged in to the SauceDemo system.

**Trigger**:

- The user selects a product to add to the shopping cart.

**Basic Flow**:

1. The user navigates to the Products page.
2. The user selects a product and clicks the "Add to Cart" button.
3. The system adds the product to the shopping cart.
4. The shopping cart icon updates to reflect the number of items in the cart.

**Postconditions**:

- The product is added to the cart, and the cart count is updated.

**Exceptions**:

- If there is a system error or the product cannot be added, an error message should be displayed.

---

### Use Case 4: Complete the Checkout Process

**Primary Actor**: Logged-in user

**Preconditions**:

- The user has at least one product in their shopping cart.

**Trigger**:

- The user proceeds to checkout after reviewing the items in their cart.

**Basic Flow**:

1. The user clicks the shopping cart icon.
2. The user reviews the cart contents and clicks the "Checkout" button.
3. The user fills in the required personal information (first name, last name, postal code) and clicks "Continue".
4. The system displays a summary of the order.
5. The user clicks the "Finish" button to complete the checkout process.
6. The system confirms that the order is complete and displays a success message.

**Postconditions**:

- The user successfully completes the checkout process, and the order confirmation is displayed.

**Exceptions**:

- If any required information is missing during the checkout process, an error message should be displayed prompting the user to fill in the missing fields.

---

## Running the Tests

To run the test suite, follow these steps:

1. **Ensure that all dependencies are installed** (e.g., Java, Maven, WebDriver, etc.).
2. **Run the tests using Maven**:
   ```bash
   mvn clean test
   ```
