import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HWL3Case2 {
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
    //Welcome page: navigate to main page as European customer
    @Test
    public void navigateAsCustomer() {
        // Verify that checkbox before “I am of legal drinking age in” is displayed
//Tick on checkbox
        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        checkbox.click();
//Select “Europe” from dropbox
        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options"))) ;
        select.selectByVisibleText("Europe");
//Press “Welcome” button
        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        welcomeButton.click();
//Main page should be displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.yellowtailwine.com/"));


    }


}
