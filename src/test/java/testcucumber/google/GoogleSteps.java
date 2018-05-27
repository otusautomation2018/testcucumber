package testcucumber.google;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class GoogleSteps {

    private WebDriver driver;
    private final String BASE_URL = "https://google.com";
    private final int BASE_TIMEOUT = 10;
    private final static By QUERY_NAME = By.name("q");
    private final static By RESULT_STATS_CSS = By.cssSelector("div[id=resultStats");

    @Given("^I am on the Google search page$")
    public void i_am_on_the_google_search_page() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(BASE_TIMEOUT, TimeUnit.SECONDS);

        driver.get(BASE_URL);
    }

    @When("^I search for \"(.*)\"$")
    public void i_search_for(String query) {
        WebElement searchField = driver.findElement(QUERY_NAME);
        searchField.sendKeys(query);
        searchField.submit();
    }

    @Then("The page title contains \"(.*)\"$")
    public void the_page_title_contains(String query) {
        WebElement element = driver.findElement(RESULT_STATS_CSS);
        new WebDriverWait(driver, BASE_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(driver.getTitle().contains(query));
        driver.quit();
    }
}
