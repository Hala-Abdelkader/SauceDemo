package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Checkout Page in the SauceDemo application.
 * Provides methods to interact with elements on the Checkout Page.
 */

public class CheckoutPage {

    WebDriver driver;
    /**
     * Locate the input field for the first name on the Checkout Page.
     */
    @FindBy(id = "first-name")
    WebElement firstName;

    /**
     * Locate The input field for the last name on the Checkout Page.
     */
    @FindBy(id = "last-name")
    WebElement lastName;

    /**
     * Locate the input field for the postal code on the Checkout Page.
     */
    @FindBy(id = "postal-code")
    WebElement postalCode;

    /**
     * Locate the continue button on the Checkout Page.
     */
    @FindBy(id = "continue")
    WebElement continueButton;

    /**
     * Locate the finish button on the Checkout Page.
     */
    @FindBy(id = "finish")
    WebElement finishButton;

    /**
     * Locate the completion message element on the Checkout Page.
     */
    @FindBy(className = "complete-header")
    WebElement completionMessage;


/**
 * Initializes a new instance of the CheckoutPage class.
 */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

/**
 * Enters the provided information into the corresponding fields and clicks the continue button.
 */

    public void enterInformation(String FirstName, String LastName, String PostalCode) {
        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        postalCode.sendKeys(PostalCode);
        continueButton.click();
    }

    /**
     * Clicks the finish button to complete the checkout process.
     */
    public void completeCheckout() {
        finishButton.click();
    }

    /**
     * Checks if the order is complete by verifying the completion message.
     *
     * @return true if the completion message text is "Thank you for your order!"; otherwise, false.
     */
    public boolean isOrderComplete() {
        return completionMessage.getText().equalsIgnoreCase("Thank you for your order!");
    }
}
