package testcucumber.automationpractice;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.automationpractice.MainPage;
import utils.helpers.ActionsHelpers;
import utils.helpers.WaitingsHelpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static testcucumber.BaseSteps.getDriver;
import static testcucumber.BaseSteps.getWebDriverWait;

public class OpenCategorySteps {

    private MainPage mainPage;
    private final String T_SHIRTS_PAGE_TITLE = "T-shirts - My Store";

    @Given("^I am on the Automationpractice Main page$")
    public void i_am_on_the_automationpractice_main_page() {
        mainPage = new MainPage(getDriver());
        getDriver().get(mainPage.baseUrl);
        WaitingsHelpers.waitForLoadPageByTextOnPage(getDriver(), mainPage.h1OfexpectedText, mainPage.expectedTextOnPage());
        assertTrue("Current Url not equals expected Url.", getDriver().getCurrentUrl().contains(mainPage.getUrl()));
        assertTrue(mainPage.getClass() + " is not initialized. ", mainPage.isInitialized());
    }

    @When("^I focus on Women category$")
    public void i_focus_on_women_category() {
        ActionsHelpers.focusOnElement(getDriver(), mainPage.topMenuBlock.firstCategory, mainPage.topMenuBlock.subMenu);
    }

    @And("^I click T-shirts link$")
    public void i_click_t_shirts_link() {
        mainPage.topMenuBlock.tShirtsBtn.click();
    }

    @Then("^I see T-shirts page$")
    public void i_see_t_shirts_page() {
        getWebDriverWait().until(ExpectedConditions.titleIs(T_SHIRTS_PAGE_TITLE));
        assertEquals("TShirts Page title is not displayed.",getDriver().getTitle(), T_SHIRTS_PAGE_TITLE);
    }
}
