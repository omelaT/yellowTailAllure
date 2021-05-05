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

        System.setProperty(Constants.PATH_TO_CHROME_DRIVER, Constants.SYSTEM_PROPERTY_CHROME_DRIVER );
        driver = new ChromeDriver();
        driver.get(Constants.BASICURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }
}
