import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;
import pages.WhereToBuyPage;


public class HWL3Case8  extends  JunitRunner{
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")


    @Test
    @Step("search on where to by page")
    public void whereToBy() throws InterruptedException {
        DriverProvider.INSTANCE.getDriver().get("https://www.yellowtailwine.com");

        //precondition
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();


        //where to by page
        mainPage.whereToByMenuClick();
        //   Thread.sleep(2000);
        WhereToBuyPage whereToBuyPage = new WhereToBuyPage();
        //  Enter valid data in “Your location” field

        whereToBuyPage.locationFieldOnWhereToBuyPage();


        //  3. Click on Search button
        whereToBuyPage.clickOnSearchButtonOnWhereToBuyPage();

        //  4. Verify that the results of search are displayed
        makeScreenshot();
        Assertions.assertTrue(whereToBuyPage.searchResultOnWhereToBuyPage());

    }
}
