package web_saucedemo.contexts;

/**
 * Data model for the user's information during the checkout process.
 * This class represents the personal information required to complete the checkout form,
 * including first name, last name, and postal code.
 */
public class CheckoutYourInfoData {

    // Private variables to store personal information
    private String firstName; // User's first name
    private String lastName;  // User's last name
    private String zip;       // User's postal code

    // Default constructor (useful for creating the object without initializing the fields)
    public CheckoutYourInfoData() {
        // Default constructor
    }

    // Overloaded constructor to directly initialize all fields
    public CheckoutYourInfoData(String firstName, String lastName, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for postal code
    public String getZip() {
        return zip;
    }

    // Setter for postal code
    public void setZip(String zip) {
        this.zip = zip;
    }

    // Optional method to display the object as a string (useful for debugging)
    @Override
    public String toString() {
        return "CheckoutYourInfoData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
