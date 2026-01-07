package framework.pages;

import framework.core.driver.DriverManager;
import framework.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
    }

    protected WebElement $(By locator) {
        return Waits.visible(locator);
    }

    protected void click(By locator) {
        Waits.safeClick(locator);
    }

    protected void type(By locator, String text) {
        WebElement el = $(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String text(By locator) {
        return $(locator).getText();
    }
}
