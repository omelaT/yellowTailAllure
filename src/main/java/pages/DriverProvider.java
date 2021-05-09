package pages;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.Properties;
import static utils.Constants.FILENAME_WITH_PROPERTIES;

public class DriverProvider {

     public static final DriverProvider INSTANCE = new DriverProvider();

      private ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

        private DriverProvider() {
        }


    public  WebDriver getDriver(){
        if (DRIVER.get() == null) {
            String browserType = loadProperties().getProperty("browserType");
            DRIVER.set(DriverFactory.createDriver(BrowserType.valueOf(browserType)));
        }
        return DRIVER.get();
    }
    public void removeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }
    /*
        private WebDriver createDriverInstance() {
            return createDriverInstance(BROWSER_TYPE.CHROME);
        }
         */
/*
 /* выносим в фабрику
    public WebDriver createInstance(BROWSER_TYPE browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
                DRIVER.set(new ChromeDriver());
                break;
            case SAFARI:
                DRIVER.set(new SafariDriver());
                break;
            default:
                throw new RuntimeException("Configuration for " + browserType + "is not exist")
        }
        return DRIVER.get();
    }
    */
    //переделываем под фабрику
  //  static WebDriver driver;

/*
    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = loadProperties().getProperty("browserType");
            driver = DriverFactory.createDriver(BrowserType.valueOf(browserType));
        }
        return driver;
    }

 */

    public static Properties loadProperties() {
        String current = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String resourcesFolder = "src" + separator + "main" + separator + "resources";

        Path file = Paths.get(current + separator + resourcesFolder + separator + FILENAME_WITH_PROPERTIES);

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No such properties file");
        }
        return properties;
    }
/*
    public void removeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }
   */

  /* static  WebDriver driver;

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

   */ //переделываем под фабрику
     /* static  WebDriver driver;

    private  static WebDriver createDriver() {
        System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
        return new ChromeDriver();
    }
        //firefox
     //  System.setProperty( Constants.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constants.PATH_TO_FIREFOX_DRIVER );
    //   return  new FirefoxDriver(); }

    public  static WebDriver getDriver(){
        if (driver==null){
            driver = DriverFactory.createDriver("firefox");
        }
        return driver;
    }

   */

}
