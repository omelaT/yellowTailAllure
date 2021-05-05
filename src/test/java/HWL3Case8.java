import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WelcomePage;
import pages.WhereToBuyPage;


public class HWL3Case8  extends  JunitRunner{


    @Test
    public void whereToBy() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");

        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();


        //where to by page
        mainPage.whereToByMenuClick();
        //   Thread.sleep(2000);
        WhereToBuyPage whereToBuyPage = new WhereToBuyPage(driver);
        //  Enter valid data in “Your location” field

        whereToBuyPage.locationFieldOnWhereToBuyPage();


        //  3. Click on Search button
        whereToBuyPage.clickOnSearchButtonOnWhereToBuyPage();

        //  4. Verify that the results of search are displayed

        Assertions.assertTrue(whereToBuyPage.searchResultOnWhereToBuyPage());

    }
}
