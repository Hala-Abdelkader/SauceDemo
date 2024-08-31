package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Represents the Products Page in the SauceDemo application.
 * Provides methods to interact with elements on the Products Page.
 */
public class ProductsPage {


    /**
     * Locate the dropdown for sorting products on the Products Page.
     */
    @FindBy(className="product_sort_container")
    WebElement dropdown;


    /**
     * Locate the button to add the product to the cart.
     */
    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> AddToCartButtons;

    /**
     * Locate the button to navigate to the shopping cart.
     */
    @FindBy(className = "shopping_cart_link")
    WebElement CartButton;

/**
 * Initializes a new instance of the ProductsPage class.
 */
    public ProductsPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    /**
     * Sorts the products by price from low to high.
     */
    public void sortByPriceLowToHigh() {
        // Create a Select object
        Select Dropdown = new Select(dropdown);

        // Select "Price (low to high)" option by visible text
        Dropdown.selectByVisibleText("Price (low to high)");

    }

/**
 * Adds the lowest-priced product to the cart.
 */
      public void AddLowestProductToCart(){
          // Add the first product to the cart (lowest price)
          if (!AddToCartButtons.isEmpty()) {
              AddToCartButtons.getFirst().click();
          } else {
              System.out.println("No products found to add to cart.");
          }
     }
    /**
     * Navigates to the shopping cart.
     */
     public void GotoCart()
     {
         CartButton.click();
     }
}
