package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static String driverName;
    private static WebDriver driver;
    private static final String PATH_TO_PROPERTIES = "properties/settings.properties";

    public static WebDriver createFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    public static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver createHeadlessChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    public static WebDriver createRemoteChromeDriver() {
        String urlRemoteDriver = PropertyReader.getPropertyFromFile(PATH_TO_PROPERTIES, "url.remote.driver");
        WebDriverManager.chromedriver().setup();
        try {
            driver = new RemoteWebDriver(new URL(urlRemoteDriver), DesiredCapabilities.chrome());
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        driverName = System.getProperty("browser");
        if(driverName == null) {
            driverName = PropertyReader.getPropertyFromFile(PATH_TO_PROPERTIES, "browser");
        }
        switch (driverName){
            case "chrome":
                driver =  createChromeDriver();
                break;
            case "chrome-headless":
                driver =  createHeadlessChromeDriver();
                break;
            case "chrome-remote":
                driver =  createRemoteChromeDriver();
                break;
            case "firefox":
                driver =  createFireFoxDriver();
                break;
            case "opera":
                driver =  createOperaDriver();
                break;
            default: driver =  createChromeDriver();
        }
        return driver;
    }
}
