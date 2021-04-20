import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HWL3Case8 {
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
    /*

2. Enter valid data in “Your location” field
3. Click on Search button
4. Verify that the results of search are displayed
     */

    @Test
    public void whereToBy()  {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        checkbox.click();
        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByVisibleText("Europe");
        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        welcomeButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.yellowtailwine.com/"));

        //where to by page
       WebElement whereToBymenu = driver.findElement(By.cssSelector(".main-nav a[href=\"https://www.yellowtailwine.com/stores/\"]"));
        whereToBymenu.click();

      //  Enter valid data in “Your location” field

        WebElement locationField = driver.findElement(By.cssSelector("#locationNamev"));
        locationField.sendKeys("Kyiv");

      //  3. Click on Search button
        WebElement searchButton = driver.findElement(By.cssSelector(".search-submit"));
        searchButton.click();

      //  4. Verify that the results of search are displayed
}}
