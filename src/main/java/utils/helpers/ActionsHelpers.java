package utils.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionsHelpers {

    private static Actions action;
    private WebDriver driver;

    public ActionsHelpers(WebDriver driver) {
        this.driver = driver;
        this.action = getInstanceAction(driver);
    }

    public static Actions getInstanceAction(WebDriver driver) {
        if( action == null) {
            action = new Actions(driver);
        }
        return action;
    }

    public static void focusOnElement(WebDriver driver, WebElement focusElement, WebElement visibilityOfElement) {
        getInstanceAction(driver)
                .moveToElement(focusElement)
                .build()
                .perform();
        WaitingsHelpers.getInstanceWebDriverWait(driver).until(ExpectedConditions.visibilityOf(visibilityOfElement));
    }
}
