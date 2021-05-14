import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;


public class HWL3Case5 extends JunitRunner {
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")


    @Test
    public void menuButtonLogic() throws InterruptedException {
        DriverProvider.INSTANCE.getDriver().get("https://www.yellowtailwine.com");
        WelcomePage welcomePage = new WelcomePage();

        //precondition
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());

        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();

        //Click on [yellow tail]
        mainPage.clickOnYellowTailOnMainPage();
        makeScreenshot();

        //Verify that Menu button is visible
        Assertions.assertTrue(mainPage.menuButtonIsDisplayedOnMainPage());

        System.out.println("success");


    }
}
