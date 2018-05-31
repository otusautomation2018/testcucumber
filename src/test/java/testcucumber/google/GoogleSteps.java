package testcucumber.google;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static testcucumber.BaseSteps.getDriver;
import static testcucumber.BaseSteps.getWebDriverWait;

public class GoogleSteps {

    private final String BASE_URL = "https://google.com";
    private final static By QUERY_NAME = By.name("q");
    private final static By RESULT_STATS_CSS = By.cssSelector("div[id=resultStats");

    @Given("^I am on the Google search page$")
    public void i_am_on_the_google_search_page() {
        getDriver().get(BASE_URL);
    }

    @When("^I search for \"(.*)\"$")
    public void i_search_for(String query) {
        WebElement searchField = getDriver().findElement(QUERY_NAME);
        searchField.sendKeys(query);
        searchField.submit();
    }

    @Then("The page title contains \"(.*)\"$")
    public void the_page_title_contains(String query) {
        WebElement element = getDriver().findElement(RESULT_STATS_CSS);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(getDriver().getTitle().contains(query));
    }
}
