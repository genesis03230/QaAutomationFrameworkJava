package framework.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By loginLink = By.id("login2");
    private final By welcomeUser = By.id("nameofuser");

    public void openLoginModal() {
        click(loginLink);
    }

    public String getWelcomeText() {
        return $(welcomeUser).getText();
    }

    public void waitForWelcome() {
        framework.utils.Waits.visible(By.id("nameofuser"));
    }
}
