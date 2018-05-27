package testcucumber.automationpractice;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.automationpractice.MainPage;
import utils.Driver;
import utils.PropertyReader;
import utils.helpers.ActionsHelpers;
import utils.helpers.WaitingsHelpers;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpenCategorySteps {

    public int baseTimeout = Integer.parseInt(PropertyReader.
            getPropertyFromFile("properties/settings.properties", "timeout"));

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public void prepare(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(baseTimeout, TimeUnit.SECONDS);
        webDriverWait = WaitingsHelpers.getInstanceWebDriverWait(driver);
    }

    private MainPage mainPage;
    private final String T_SHIRTS_PAGE_TITLE = "T-shirts - My Store";

    @Given("^I am on the Automationpractice Main page$")
    public void i_am_on_the_automationpractice_main_page() {
        prepare();
        mainPage = new MainPage(driver);
        driver.get(mainPage.baseUrl);
        WaitingsHelpers.waitForLoadPageByTextOnPage(driver, mainPage.h1OfexpectedText, mainPage.expectedTextOnPage());
        assertTrue("Current Url not equals expected Url.", driver.getCurrentUrl().contains(mainPage.getUrl()));
        assertTrue(mainPage.getClass() + " is not initialized. ", mainPage.isInitialized());


    }

    @When("^I focus on Women category$")
    public void i_focus_on_women_category() {
        ActionsHelpers.focusOnElement(driver, mainPage.topMenuBlock.firstCategory, mainPage.topMenuBlock.subMenu);
    }

    @And("^I click T-shirts link$")
    public void i_click_t_shirts_link() {
        mainPage.topMenuBlock.tShirtsBtn.click();
    }

    @Then("^I see T-shirts page$")
    public void i_see_t_shirts_page() {
        webDriverWait.until(ExpectedConditions.titleIs(T_SHIRTS_PAGE_TITLE));
        assertEquals("TShirts Page title is not displayed.",driver.getTitle(), T_SHIRTS_PAGE_TITLE);
        quit();
    }

    public void quit() {
        driver.quit();
    }
}
