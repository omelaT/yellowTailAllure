import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.DriverProvider;
import pages.MainPage;
import pages.WeiboComMainPage;
import pages.WelcomePage;


import java.util.Set;


public class HWL4Case7 extends JunitRunner {
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")


    @Test
    public void mainPageGlobalNavLogic() throws InterruptedException {
        //precondition
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button

        mainPage.clickOnMenuButtonOnMainPage();
        //Globe icon
        mainPage.globeIconIsVisible();

        //wait
        mainPage.waitForGlobeIcon();

        //click o Globe icon
        mainPage.clickOnTheGlobeIcon();

        //Select China
        mainPage.waitForElementChina();

        mainPage.selectChinaAndClick();

        System.out.println("success click");


        //click
        Set<String> oldWindowsSet = DriverProvider.INSTANCE.getDriver().getWindowHandles();
        mainPage.clickOnRedirectIcon();
        System.out.println("success click 2");

        WeiboComMainPage weiboComMainPage = new WeiboComMainPage();

        weiboComMainPage.getDescription(oldWindowsSet);
        makeScreenshot();
        //Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
        Assertions.assertTrue(DriverProvider.INSTANCE.getDriver().getCurrentUrl().contains("weibo"));
        DriverProvider.INSTANCE.getDriver().close();

    }
}