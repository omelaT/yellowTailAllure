package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static utils.Constants.PATH_TO_CHROME_DRIVER;
import static utils.Constants.SYSTEM_PROPERTY_CHROME_DRIVER;

public class DriverFactory {

    public static WebDriver createDriver(BrowserType browserName) {
        //String browserType = "chrome"  //path to file get prop
        WebDriver driver;
        switch (browserName) {
            case CHROME:
                System.setProperty(SYSTEM_PROPERTY_CHROME_DRIVER, PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Configuration for " + browserName + "is NOT exist");
        }
        return driver;
    }
}
