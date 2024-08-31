package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Cart Page in the SauceDemo application.
 * Provides methods to interact with elements on the Cart Page.
 */

public class CartPage {

    //Locate the checkout button element by ID
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    //Initializes a new instance of the CartPage class.
    public CartPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    /**
     * Clicks the checkout button to proceed to the checkout process.
     */

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}
