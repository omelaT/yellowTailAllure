import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case3 extends JunitRunner {
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")


    @Test
    public void requirenmentElementsDisplayedOnMainPage() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        DriverProvider.INSTANCE.getDriver().get("https://www.yellowtailwine.com");
        //precondition
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(DriverProvider.INSTANCE.getDriver().getCurrentUrl().contains("https://www.yellowtailwine.com/"));

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
        makeScreenshot();
        Assertions.assertTrue(mainPage.footerOnOnMainPage());
        //   System.out.println("footer");


    }
}