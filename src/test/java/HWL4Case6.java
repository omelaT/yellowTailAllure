import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case6 extends JunitRunner {
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")

    @Test
    public void requirenmentElementsDisplayedOnMainPage() throws InterruptedException {
        DriverProvider.INSTANCE.getDriver().get("https://www.yellowtailwine.com");
        //precondition
        WelcomePage welcomePage = new WelcomePage();

        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        System.out.println("main page");
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();
        System.out.println("click on menu btn");

        //Click on Globe icon
        mainPage.clickOnTheGlobeIcon();
        System.out.println("click globe btn");

        mainPage.waitForElementChina();
        //Select China
        mainPage.selectChinaAndClick();
        System.out.println("success click");
        makeScreenshot();
        // Verify that language is changed
        //- find your wine button
        Assertions.assertTrue(mainPage.getChangedLanguageOnFindYourWineButton().contains("发现适合你的酒"));
        System.out.println("success");
    }
}