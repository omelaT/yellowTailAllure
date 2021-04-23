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

public class HWL4Case6 {
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
    public void requirenmentElementsDisplayedOnMainPage() throws InterruptedException {
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

        //Click on Globe icon
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.fa.fa-globe.fa-lg',':before').click();");

        //Select Ch
        WebElement chinaButton = driver.findElement(By.cssSelector("[data-key=\"CN\"]"));
        chinaButton.click();

       // Verify that language is changed



    }
}