package framework.utils;

import framework.core.config.ConfigManager;
import framework.core.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class Waits {
    private Waits() {}

    private static WebDriverWait waitDefault() {
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(ConfigManager.getExplicitWaitSeconds())
        );
    }

    public static WebElement visible(By locator) {
        return waitDefault().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement clickable(By locator) {
        return waitDefault().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean invisible(By locator) {
        return waitDefault().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void urlContains(String partial) {
        waitDefault().until(ExpectedConditions.urlContains(partial));
    }

    public static void safeClick(By locator) {
        try {
            clickable(locator).click();
        } catch (StaleElementReferenceException e) {
            clickable(locator).click();
        } catch (ElementClickInterceptedException e) {
            // fallback simple: JS click
            WebElement el = clickable(locator);
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", el);
        }
    }
}
