package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Constants;

public class DriverProvider {
   static  WebDriver driver;
    private  static WebDriver createDriver() {
        System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
        return new ChromeDriver();
    }
        //firefox
     //  System.setProperty( Constants.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constants.PATH_TO_FIREFOX_DRIVER );
    //   return  new FirefoxDriver(); }

    public  static WebDriver getDriver(){
        if (driver==null){
            driver = createDriver();
        }
        return driver;

    }

}
