import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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

        //Verify that “I am of legal drinking age in” is displayed
          WebElement text = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
          Assertions.assertTrue(text.getText().contains("I am of legal drinking age in"));
        // Verify that checkbox before “I am of legal drinking age in” is displayed

        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        Assertions.assertTrue(checkbox.isDisplayed());

        //Verify that dropdown with Select is displayed

           WebElement select = driver.findElement(By.cssSelector(".agegate-selector-options"));
           Assertions.assertTrue(select.isDisplayed());

        //Verify that “Welcome” button is displayed and is inactive

       WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        Assertions.assertTrue(welcomeButton.isDisplayed());
        Assertions.assertFalse(welcomeButton.isEnabled());

    }

}
