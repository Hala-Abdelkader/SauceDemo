package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Login Page in the SauceDemo application.
 * Provides methods to interact with elements on the Login Page.
 */
public class LoginPage {
    WebDriver driver;

    /**
     * Locate the input field for the username on the Login Page.
     */
    @FindBy(id = "user-name")
    WebElement username;

    /**
     * Locate the input field for the password on the Login Page.
     */
    @FindBy(id = "password")
    WebElement password;

    /**
     * Locate the login button on the Login Page.
     */
    @FindBy(id = "login-button")
    WebElement loginButton;

/**
 * Initializes a new instance of the LoginPage class.
 */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

/**
 * Performs login by entering the provided username and password, and clicking the login button.
 */
    public void login(String Username, String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);
        loginButton.click();
    }
}
