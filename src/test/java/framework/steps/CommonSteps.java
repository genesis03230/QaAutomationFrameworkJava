package framework.steps;

import framework.core.config.ConfigManager;
import framework.utils.AlertUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonSteps {

    @Then("an alert should be shown with message {string}")
    public void anAlertShouldBeShownWithMessage(String expected) {
        String actual = AlertUtil.waitAndGetTextThenAccept(ConfigManager.getExplicitWaitSeconds());
        Assert.assertEquals(expected, actual);
    }
}
