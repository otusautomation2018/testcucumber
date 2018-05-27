package utils.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.PropertyReader;

public class WaitingsHelpers {

    private static int baseTimeout = Integer.parseInt(PropertyReader.
            getPropertyFromFile("properties/settings.properties", "timeout"));

    private static WebDriverWait webDriverWait;

    public static WebDriverWait getInstanceWebDriverWait(WebDriver driver) {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, baseTimeout);
        }
        return webDriverWait;
    }
    public static void waitForLoadPageByTextOnPage(WebDriver driver, WebElement expectedElement, String expectedText){
        getInstanceWebDriverWait(driver).until(
                ExpectedConditions.textToBePresentInElement(expectedElement, expectedText));
    }
}
