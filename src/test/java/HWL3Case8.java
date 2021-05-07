import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;
import pages.WhereToBuyPage;


public class HWL3Case8  extends  JunitRunner{


    @Test
    public void whereToBy() throws InterruptedException {
        DriverProvider.getDriver().get("https://www.yellowtailwine.com");

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

        Assertions.assertTrue(whereToBuyPage.searchResultOnWhereToBuyPage());

    }
}
