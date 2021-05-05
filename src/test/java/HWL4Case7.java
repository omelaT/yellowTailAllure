import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.MainPage;
import pages.WelcomePage;
import utils.Constants;


import java.util.Set;


public class HWL4Case7 extends  JunitRunner {


    @Test
    public void mainPageGlobalNavLogic() throws InterruptedException {
     //   driver.get(Constants.BASICURL);

        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();
        //Click on Globe icon
     //   Thread.sleep(10000);
      //  mainPage.globeIconIsVisible();
        mainPage.waitForGlobeIcon();

        mainPage.clickOnTheGlobeIcon();

        //Select China
        mainPage.selectChinaAndClick();
        System.out.println("success click");
      Thread.sleep(10000);
       // WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        //. Click on icon ( in white square on screenshot)

        Set<String> oldWindowsSet = driver.getWindowHandles();
       mainPage.clickOnIconAfterChinaSelected();
        System.out.println("success click 2");
        Thread.sleep(21000);
        WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);

        //Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
      //  WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        weiboComMainPage.getDescription(oldWindowsSet);

      // WeiboComMainPage weiboComMainPage = new WeiboComMainPage(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("yellowtailChina"));

        driver.close();


    }
}