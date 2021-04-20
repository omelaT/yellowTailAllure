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


import java.util.List;

public class FirstTest {
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
    public void navigateToMainPage() {
        driver.get("https://www.google.com/");

        By searchField = By.cssSelector(".gLFyf.gsfi");
        WebElement searchElement = driver.findElement(searchField);

        searchElement.click();

        searchElement.sendKeys("Апельсин");

        //click enter bttn
        searchElement.sendKeys(Keys.ENTER);
        //get first search result and verifiy the title conteins  apelsin
        By searchResultsSelector = By.cssSelector(".LC20lb.DKV0Md");
        List<WebElement> searchResults = driver.findElements(searchResultsSelector);

 /*for (WebElement item:searchResults ){
     Assertions.assertTrue(item.getText().contains("Апельсин"));
 }
 */
        Assertions.assertTrue(searchResults.get(0).getText().contains("Апельсин — Википедия"));

    }

    @Test
    public void verifyThatMobileCategoryHasValidTitle() {

        driver.get("https://rozetka.com.ua/mobile-phones/c80003/");
        WebElement categoryName = driver.findElement(By.cssSelector("h1.catalog-heading"));
        Assertions.assertTrue(categoryName.getText().contains("Мобильные телефоны"));
        //mobile-phones
        Assertions.assertTrue(driver.getCurrentUrl().contains("mobile-phones"));
    }

    @Test
public void verifySortingAccrdingPrice(){
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/");

        Select select = new Select(driver.findElement(By.cssSelector("select.select-css"))) ;
        select.selectByIndex(2);
        System.out.println("Success");
        //Assertions.assertTrue(categoryName.getText().contains("Мобильные телефоны"));
    }

}

