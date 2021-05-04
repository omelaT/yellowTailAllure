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

public class HWL4Case6 {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void requirenmentElementsDisplayedOnMainPage() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());

        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();

        //Click on Globe icon
        mainPage.clickOnTheGlobeIcon();

        //Select China
        mainPage.selectChinaAndClick();
        System.out.println("success click");
        // Verify that language is changed
        //- find your wine button
       // WebElement findYourWineButton = driver.findElement(By.cssSelector("[class=\"sgg-comp-button-inner\"]"));
        Assertions.assertTrue( mainPage.getChangedLanguageOnFindYourWineButton().contains("发现适合你的酒"));
        System.out.println("success");
    }
}