package framework.core.driver;

import framework.core.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createDriver() {
        BrowserType browser = ConfigManager.getBrowser();
        boolean headless = ConfigManager.isHeadless();

        WebDriver driver;

        switch (browser) {
            case FIREFOX -> {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) options.addArguments("-headless");
                driver = new FirefoxDriver(options);
            }
            case EDGE -> {
                EdgeOptions options = new EdgeOptions();
                if (headless) options.addArguments("--headless=new");
                driver = new EdgeDriver(options);
            }
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("Browser no soportado: " + browser);
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigManager.getPageLoadTimeoutSeconds()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigManager.getImplicitWaitSeconds()));

        return driver;
    }
}
