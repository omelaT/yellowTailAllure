import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HWL4Case3 {
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

        //1. Navigate to main page - done

        //2. Verify that the following elements are displayed:
        //- menu button
        WebElement menuButton = driver.findElement(By.cssSelector(".fa.fa-bars"));
        Assertions.assertTrue(menuButton.isDisplayed());

        //- WELCOME TO THE WORLD OF [Yellow tail]
        WebElement titleOnMainPage = driver.findElement(By.cssSelector("[class = \"content animation-screen -one\"] h2"));
        Assertions.assertTrue(titleOnMainPage.isDisplayed());

        //- We are passionate about creating great tasting, quality wines for everyone to
        WebElement passionateText = driver.findElement(By.cssSelector("[class=\"content animation-screen -one\"] p"));
        Assertions.assertTrue(passionateText.isDisplayed());

        //enjoy
        WebElement enjoyText = driver.findElement(By.cssSelector("[class=\"content animation-screen -one\"] p"));
        Assertions.assertTrue(enjoyText.isDisplayed());

        //- find your wine button
        WebElement findYourWineButton = driver.findElement(By.cssSelector("[class=\"content animation-screen -one\"]> a"));
        Assertions.assertTrue(findYourWineButton.isDisplayed());

        //- footer
        WebElement footer = driver.findElement(By.cssSelector(".primary-footer"));
        Assertions.assertTrue(footer.isDisplayed());


    }
}