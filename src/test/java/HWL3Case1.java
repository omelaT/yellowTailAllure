import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWL3Case1 {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com");
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void verifyLegalTextIsdisplayed() {

        //Verify that “I am of legal drinking age in” is displayed
          WebElement text = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
          Assertions.assertTrue(text.getText().contains("I am of legal drinking age in"));
    }
    @Test
    public void verifyCheckboxIsdisplayed() {
        // Verify that checkbox before “I am of legal drinking age in” is displayed

        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        Assertions.assertTrue(checkbox.isDisplayed());
    }
    @Test
    public void verifyDropdownIsdisplayed() {
        //Verify that dropdown with Select is displayed

           WebElement select = driver.findElement(By.cssSelector(".agegate-selector-options"));
           Assertions.assertTrue(select.isDisplayed());
    }
    @Test
    public void verifyWelcomeIsDisplayed() {
        //Verify that “Welcome” button is displayed and is inactive

       WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        Assertions.assertTrue(welcomeButton.isDisplayed());
        Assertions.assertFalse(welcomeButton.isEnabled());

    }

}
