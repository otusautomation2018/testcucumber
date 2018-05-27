package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BasePage {

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
