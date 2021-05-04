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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void whereToBy() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");

        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();


        //where to by page
        mainPage.whereToByMenuClick();
        //   Thread.sleep(2000);
        WhereToBuyPage whereToBuyPage = new WhereToBuyPage(driver);
        //  Enter valid data in “Your location” field

        whereToBuyPage.locationFieldOnWhereToBuyPage();


        //  3. Click on Search button
        whereToBuyPage.clickOnSearchButtonOnWhereToBuyPage();

        //  4. Verify that the results of search are displayed

        Assertions.assertTrue(whereToBuyPage.searchResultOnWhereToBuyPage());

    }
}
