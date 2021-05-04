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

public class HWL4Case3 {
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
    public void requirenmentElementsDisplayedOnMainPage() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        driver.get("https://www.yellowtailwine.com");
        //precondition
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.yellowtailwine.com/"));

        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
     //   System.out.println("mainPage");
        Assertions.assertTrue(mainPage.menuButtonIsDisplayedOnMainPage());
     //   System.out.println("menuButton");
        Assertions.assertTrue(mainPage.titleOnMainPageIsDisplayed());
     //   System.out.println("titleOnMainPage");
        Assertions.assertTrue(mainPage.passionateTextIsDisplayedOnMainPage());
     //   System.out.println("passionateText");
        Assertions.assertTrue(mainPage.enjoyTextIsDisplayedOnMainPage());
     //   System.out.println("enjoyText");
        Assertions.assertTrue(mainPage.findYourWineButtonIsDisplayedOnMainPage());
     //   System.out.println("findYourWineButton");
        Assertions.assertTrue(mainPage.footerOnOnMainPage());
     //   System.out.println("footer");


    }
}