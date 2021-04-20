import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class HWL3Case4 {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        driver = new ChromeDriver();
        // driver.get("https://www.yellowtailwine.com");
    }

    @AfterEach
    public void after() {
        // driver.quit();
    }

    @Test
    public void menuButtonLogic() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        checkbox.click();
        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByVisibleText("Europe");
        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        welcomeButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.yellowtailwine.com/"));

        //2. Click on Menu button
        WebElement menuButton = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuButton.click();

//Verify that header with all needed links is appeared
        WebElement wineLink = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/wines/\"]"));
        Assertions.assertTrue(wineLink.isDisplayed());

        WebElement whereToBue = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/stores/\"]"));
        Assertions.assertTrue(whereToBue.isDisplayed());

        WebElement coctails = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/cocktails/\"]"));
        Assertions.assertTrue(coctails.isDisplayed());

        WebElement ourStory = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/our-story/\"]"));
        Assertions.assertTrue(ourStory.isDisplayed());

        WebElement faqs = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/faqs/\"]"));
        Assertions.assertTrue(faqs.isDisplayed());

        WebElement contact = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/contact/\"]"));
        Assertions.assertTrue(contact.isDisplayed());

      //  4. Click on [yellow tail]
        WebElement logo = driver.findElement(By.cssSelector(".yt-logo"));
        logo.click();
      //  5. Verify that Menu button is visible
        Assertions.assertTrue(menuButton.isDisplayed());




    }
}




