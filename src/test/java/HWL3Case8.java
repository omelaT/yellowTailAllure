import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class HWL3Case8 {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
    public void whereToBy() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        //check checkbox
        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        checkbox.click();
        //choose europe
        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByVisibleText("Europe");
        // Welcome button click
        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        welcomeButton.click();
        // check that we ere on the main page
        WebElement mainpage = driver.findElement(By.cssSelector(".large-mobile"));
        Assertions.assertTrue(mainpage.isDisplayed());

        // Click on Menu button
        WebElement menuButton = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuButton.click();
        Thread.sleep(2000);

        //where to by page
       WebElement whereToBymenu = driver.findElement(By.cssSelector("[href*=\"stores\"]"));
        whereToBymenu.click();
        Thread.sleep(2000);

      //  Enter valid data in “Your location” field

       WebElement locationField = driver.findElement(By.cssSelector("[id=\"locationName\"]"));
        locationField.sendKeys("Kiev Street, Merrylands NSW, Australia");
        locationField.sendKeys(Keys.ENTER);


      //  3. Click on Search button
        WebElement searchButton = driver.findElement(By.cssSelector(".search-submit"));
        searchButton.click();
        Thread.sleep(2000);

      //  4. Verify that the results of search are displayed
        WebElement searchResult = driver.findElement(By.cssSelector("[class=\"tile\"]:first-child"));
        Assertions.assertTrue(searchResult.isDisplayed());

}}
