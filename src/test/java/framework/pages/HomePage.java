package framework.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By loginLink = By.id("login2");
    private final By welcomeUser = By.id("nameofuser");
    private final By cartLink = By.id("cartur");

    public void openLoginModal() {
        click(loginLink);
    }

    public String getWelcomeText() {
        return $(welcomeUser).getText();
    }

    public void waitForWelcome() {
        framework.utils.Waits.visible(By.id("nameofuser"));
    }


    public void openCart() {
        click(cartLink);
    }

    public void openProductByName(String productName) {
        click(By.linkText(productName));
    }
}
