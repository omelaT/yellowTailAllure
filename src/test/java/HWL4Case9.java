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

public class HWL4Case9 {


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
    public void selectOneWine() throws InterruptedException {
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

        //  Select “Red wine cocktails”
        //1 click toggle .toggle
        WebElement toggle = driver.findElement(By.cssSelector(".toggle"));
        toggle.click();
        //[data-value="red"] dropdown click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('[data-value=\"red\"]',':before').click();");
        Thread.sleep(3000);
        //close dropdown
        WebElement toggle1 = driver.findElement(By.cssSelector(".toggle"));
        toggle1.click();
        Thread.sleep(1000);

        //Verify that 7 recipes are displayed

        int count = driver.findElements(By.cssSelector("[class=\"tile recipe-tile\"]")).size();
        System.out.println(count);
        Assertions.assertEquals(7,count);
    }

}