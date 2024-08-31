package tests;

import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.*;
import utils.JsonUtils;

/**
 * Test class for automating the SauceDemo application using Selenium WebDriver and TestNG.
 * This class performs the end-to-end scenario for logging in, adding a product to the cart,
 * proceeding to checkout, and verifying the order completion.
 */
public class SauceDemoTest {


    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    JsonNode userData;

    /**
     * Sets up the WebDriver instance and initializes the page objects before running the tests.
     * Loads user data from a JSON file.
     */
    @BeforeClass
    public void setup() {
        DriverManager.driver = new ChromeDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.get("https://www.saucedemo.com/");

        // Load JSON data
        userData = JsonUtils.parseJSON("src/test/resources/userdata.json");

        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

/**
 * Performs the complete order test by executing the following steps:
 * - Logs in with the provided username and password.
 * - Adds the lowest-priced product to the cart.
 * - Navigates to the cart.
 * - Proceeds to checkout.
 * - Enters checkout information and completes the order.
 * - Verifies if the order completion message is displayed.
 */

    @Test
    public void completeOrderTest() throws InterruptedException {
        String username = userData.get("username").asText();
        String password = userData.get("password").asText();
        String firstName = userData.get("firstName").asText();
        String lastName = userData.get("lastName").asText();
        String postalCode = userData.get("postalCode").asText();

        loginPage.login(username, password);
        Thread.sleep(3000);// Wait for login to complete
        productsPage.sortByPriceLowToHigh();
        Thread.sleep(3000);// Wait for sorting
        productsPage.AddLowestProductToCart();
        Thread.sleep(3000); // Wait for product to be added to cart
        productsPage.GotoCart();
        Thread.sleep(3000); // Wait for navigation to cart
        cartPage.proceedToCheckout();
        Thread.sleep(3000); // Wait for checkout page to load
        checkoutPage.enterInformation(firstName, lastName, postalCode);
        Thread.sleep(3000); // Wait for information entry and checkout completion
        checkoutPage.completeCheckout();
        Thread.sleep(3000); // Wait for order completion
        Assert.assertTrue(checkoutPage.isOrderComplete(), "Order was not completed successfully.");
    }

    /**
     * Cleans up the WebDriver instance after all tests have run.
     */
    @AfterClass
    public void tearDown() {
        if (DriverManager.driver != null) {
            DriverManager.driver.quit();
        }
    }
}
