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
import java.util.Set;

public class HWL4Case7 {

    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // получаем набор дескрипторов текущих открытых окон

    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void mainPageGlobalNavLogic() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
       Set<String> oldWindowsSet = driver.getWindowHandles();
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
      // Thread.sleep(10000);


        //. Click on icon ( in white square on screenshot)
       mainPage.clickOnIconAfterChinaSelected();
       // Thread.sleep(11000);
        System.out.println("success click 2");

        //Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
        WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        weiboComMainPage.newPageWeiboIsOpened();
        System.out.println("success  script");

       // WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("yellowtailChina"));
        driver.close();

        System.out.println("success");


    }
}