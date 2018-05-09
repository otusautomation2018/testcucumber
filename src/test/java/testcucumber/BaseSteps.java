package testcucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.PropertyReader;
import utils.helpers.WaitingsHelpers;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public int baseTimeout = Integer.parseInt(PropertyReader.
            getPropertyFromFile("properties/settings.properties", "timeout"));

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @Before
    public void prepare(){
        driver = Driver.getInstance();
        driver.manage().timeouts().implicitlyWait(baseTimeout, TimeUnit.SECONDS);
        webDriverWait = WaitingsHelpers.getInstanceWebDriverWait();
    }

    @After
    public void quit() {
        driver.quit();
    }
}
