import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

import java.time.Duration;

public class JunitRunner {
   WebDriver driver;

    @BeforeEach
    public void before() {
        String basicUrl = "https://www.yellowtailwine.com";

        System.setProperty( Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER );
        driver = new ChromeDriver();
        driver.get(basicUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }
}
