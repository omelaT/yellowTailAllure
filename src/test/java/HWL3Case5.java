import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HWL3Case5 {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");

        driver = new ChromeDriver();

    }

    @AfterEach
    public void after() {
         driver.quit();
    }

    @Test
    public void menuButtonLogic()  {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        checkbox.click();
        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByVisibleText("Europe");
        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        welcomeButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.yellowtailwine.com/"));


        // Click on Menu button
        WebElement menuButton = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuButton.click();

        //Click on [yellow tail]
       WebElement logo = driver.findElement(By.cssSelector(".yt-logo"));
        logo.click();

        //Verify that Menu button is visible
      Assertions.assertTrue(menuButton.isDisplayed());


    }
}
