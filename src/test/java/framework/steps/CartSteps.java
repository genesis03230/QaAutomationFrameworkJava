package framework.steps;

import framework.core.config.ConfigManager;
import framework.pages.CartPage;
import framework.pages.HomePage;
import framework.pages.ProductPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class CartSteps {

    private final HomePage homePage = new HomePage();
    private final ProductPage productPage = new ProductPage();
    private final CartPage cartPage = new CartPage();

    private String lastAlertText;

    @Given("the cart is empty")
    public void theCartIsEmpty() {
        homePage.openCart();
        cartPage.deleteAllItemsIfAny();
    }

    @When("the user opens the product {string}")
    public void theUserOpensTheProduct(String productName) {
        framework.core.driver.DriverManager.getDriver().get(ConfigManager.getBaseUrl());
        homePage.openProductByName(productName);
    }

    @When("adds the product to the cart")
    public void addsTheProductToTheCart() {
        productPage.addToCart();
    }

    @When("the user opens the cart page")
    public void theUserOpensTheCartPage() {
        homePage.openCart();
        cartPage.waitForCartToLoad();
    }

    @Then("the cart should contain product {string}")
    public void theCartShouldContainProduct(String productName) {
        cartPage.waitUntilContainsProduct(productName);
        Assert.assertTrue("Expected cart to contain: " + productName, cartPage.containsProduct(productName));
    }

    @Then("the cart total should be {int}")
    public void theCartTotalShouldBe(int expectedTotal) {
        Assert.assertEquals(expectedTotal, cartPage.getTotal());
    }
}
