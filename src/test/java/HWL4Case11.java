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

public class HWL4Case11 {

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
    public void selectSeveralWines() throws InterruptedException {
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
        Thread.sleep(1000);

       // Select “Sparkling wine cocktails”
        //[data-value="red"] dropdown click
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.querySelector('[data-value=\"bubbles\"]',':before').click();");
        Thread.sleep(3000);

        //close dropdown
        WebElement toggle1 = driver.findElement(By.cssSelector(".toggle"));
        toggle1.click();
       Thread.sleep(3000);

        //4. Verify that “Multiple” word is displayed in “Type” dropdown
        //aria-label="Type - select to access the drop down menu of wine types"
        WebElement categoryMultiple = driver.findElement(By.cssSelector("[aria-label*=\"Type \"]"));
        Assertions.assertTrue(categoryMultiple.getText().contains("Multiple"));

        //5. Verify that 18 recipes are displayed
        int count = driver.findElements(By.cssSelector("[class=\"tile recipe-tile\"]")).size();
        System.out.println(count);
        Assertions.assertEquals(18,count);
}
}