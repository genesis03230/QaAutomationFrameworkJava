package framework.utils;

import framework.core.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtil {
    private ScreenshotUtil() {}

    public static byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
