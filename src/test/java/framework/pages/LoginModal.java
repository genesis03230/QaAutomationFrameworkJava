package framework.pages;

import framework.utils.Waits;
import org.openqa.selenium.By;

public class LoginModal extends BasePage {

    private final By modalRoot = By.id("logInModal");
    private final By usernameInput = By.id("loginusername");
    private final By passwordInput = By.id("loginpassword");
    private final By loginButton = By.cssSelector("#logInModal .btn.btn-primary");

    public void waitUntilVisible() {
        Waits.visible(modalRoot);
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }
}
