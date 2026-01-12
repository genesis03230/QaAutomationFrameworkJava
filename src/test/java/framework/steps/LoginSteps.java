package framework.steps;

import framework.pages.HomePage;
import framework.pages.LoginModal;
import framework.core.config.ConfigManager;
import framework.core.driver.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps {

    private final HomePage homePage = new HomePage();
    private final LoginModal loginModal = new LoginModal();

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("demoblaze"));
    }

    @When("the user opens the login modal")
    public void theUserOpensTheLoginModal() {
        homePage.openLoginModal();
        loginModal.waitUntilVisible();
    }

    @When("logs in with username {string} and password {string}")
    public void logsInWithUsernameAndPassword(String username, String password) {
        loginModal.login(username, password);
    }

    @Then("the welcome message should contain {string}")
    public void theWelcomeMessageShouldContain(String username) {

        if (framework.utils.AlertUtil.isAlertPresent()) {
            String alertText = framework.utils.AlertUtil.waitAndGetTextThenAccept(ConfigManager.getExplicitWaitSeconds());
            Assert.fail("Expected successful login, but an alert appeared: " + alertText);
        }

        homePage.waitForWelcome();
        String welcome = homePage.getWelcomeText();

        Assert.assertTrue("Expected welcome to contain username. Actual: " + welcome,
                welcome.toLowerCase().contains(username.toLowerCase()));
    }
}
