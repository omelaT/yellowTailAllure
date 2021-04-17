import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test
    public void navigateToMainPage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        By searchField = By.cssSelector(".gLFyf.gsfi");
        WebElement searchElement = driver.findElement(searchField);

        searchElement.click();

        //Thread.sleep(1000);

        searchElement.sendKeys("Hillel");

        driver.quit();

        System.out.println("Success");

    }
}
