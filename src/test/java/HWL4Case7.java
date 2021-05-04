import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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

        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();
        //Click on Globe icon
        Thread.sleep(10000);
        mainPage.clickOnTheGlobeIcon();

        //Select China
        mainPage.selectChinaAndClick();
        System.out.println("success click");
      Thread.sleep(10000);
        WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        //. Click on icon ( in white square on screenshot)
        Set<String> oldWindowsSet = driver.getWindowHandles();
       mainPage.clickOnIconAfterChinaSelected();
        System.out.println("success click 2");
        Thread.sleep(21000);

        //Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
      //  WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        weiboComMainPage.getDescription(oldWindowsSet);

      // WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("yellowtailChina"));

        driver.close();


    }
}