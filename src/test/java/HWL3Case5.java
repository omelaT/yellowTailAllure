import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class HWL3Case5 {
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
    public void menuButtonLogic() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        WelcomePage welcomePage = new WelcomePage(driver);

        //precondition
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());

        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();

        //Click on [yellow tail]
       mainPage.clickOnYellowTailOnMainPage();

        //Verify that Menu button is visible
      Assertions.assertTrue(mainPage.menuButtonIsDisplayedOnMainPage());
        System.out.println("success");


    }
}
