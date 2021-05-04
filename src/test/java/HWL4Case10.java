import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HWL4Case10 {
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

    @Test
    public void navigateToCocktailRecipePage() throws InterruptedException {
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

        //Click on Menu button
        WebElement menuButton = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuButton.click();
        Thread.sleep(2000);

        // Navigate to “Cocktails” page
        WebElement coctails = driver.findElement(By.cssSelector("[href*=\"cocktails\"]"));
        coctails.click();
        Thread.sleep(2000);

        //2. Scroll to “RASPBERRY ROSÉ” recipe   [alt="Raspberry Rose"]
        WebElement raspberryRose = driver.findElement(By.cssSelector("[alt=\"Raspberry Rose\"]"));
// Javascript executor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", raspberryRose);

        //3. Click on “RASPBERRY ROSÉ” recipe
        raspberryRose.click();

        //4. Verify that new page is displayed: - ingredients section is displayed
        WebElement ingridientSection = driver.findElement(By.cssSelector("[class=\"recipe-intro\"]"));
        ingridientSection.isDisplayed();

    }
}