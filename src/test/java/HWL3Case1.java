import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HWL3Case1 {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void verifyElementsOnWelcomePageIsdisplayed() {
        WelcomePage welcomePage = new WelcomePage(driver);

        Assertions.assertTrue(welcomePage.legalTextDisplayedOnWelcomePage());
        Assertions.assertTrue(welcomePage.checkboxTextDisplayedOnWelcomePage());
        Assertions.assertTrue(welcomePage.selectIsDispalyedOnWelcomePage());
        Assertions.assertTrue(welcomePage.welcomeButtonIsDispalyedOnWelcomePage());
        Assertions.assertFalse(welcomePage.welcomeButtonIsInactiveOnWelcomePage());

    }

}
