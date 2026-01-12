package framework.pages;

import framework.utils.Waits;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final By productName = By.cssSelector(".name");
    private final By productPrice = By.cssSelector(".price-container");
    private final By addToCartLink = By.linkText("Add to cart");

    public String getName() {
        return $(productName).getText();
    }

    public String getPriceText() {
        return $(productPrice).getText();
    }

    public void addToCart() {
        Waits.clickable(addToCartLink).click();
    }
}
