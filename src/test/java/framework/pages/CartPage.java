package framework.pages;

import framework.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.core.config.ConfigManager;
import framework.core.driver.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import java.util.List;

public class CartPage extends BasePage {

    private final By totalPrice = By.id("totalp");
    private final By cartRows = By.cssSelector("#tbodyid > tr");
    private final By deleteLinks = By.cssSelector("#tbodyid a");

    public void waitForCartToLoad() {
        Waits.visible(By.id("tbodyid"));
    }

    public boolean containsProduct(String productName) {
        List<WebElement> rows = driver.findElements(cartRows);
        return rows.stream().anyMatch(r -> r.getText().contains(productName));
    }

    public int getTotal() {
        String txt = driver.findElement(totalPrice).getText().trim();
        if (txt.isEmpty()) return 0;
        return Integer.parseInt(txt);
    }

    public void deleteAllItemsIfAny() {
        waitForCartToLoad();

        while (!driver.findElements(cartRows).isEmpty()) {
            driver.findElements(deleteLinks).get(0).click();
            Waits.invisible(By.cssSelector("#tbodyid > tr"));
            waitForCartToLoad();
        }
    }

    public void waitUntilContainsProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(ConfigManager.getExplicitWaitSeconds())
        );

        wait.until(textToBePresentInElementLocated(By.id("tbodyid"), productName));
    }
}
