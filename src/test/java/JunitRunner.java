import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.DriverProvider;

import java.time.Duration;

public class JunitRunner {


    @BeforeEach
    public void before() {

        String basicUrl = "https://www.yellowtailwine.com";
        DriverProvider.getDriver();
      //  System.setProperty( Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER );
      //  driver = new ChromeDriver();
        DriverProvider.getDriver().get(basicUrl);
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void after() {
        DriverProvider.getDriver().quit();
    }
}
