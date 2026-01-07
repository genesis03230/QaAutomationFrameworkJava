package framework.core.hooks;

import framework.core.config.ConfigManager;
import framework.core.driver.DriverFactory;
import framework.core.driver.DriverManager;
import framework.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        ConfigManager.init();

        WebDriver driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);

        driver.get(ConfigManager.getBaseUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ScreenshotUtil.takeScreenshotAsBytes();
                scenario.attach(screenshot, "image/png", "screenshot-on-failure");
            }
        } finally {
            DriverManager.quitDriver();
        }
    }
}
