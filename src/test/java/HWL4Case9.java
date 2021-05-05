import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CoctailPage;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case9  extends JunitRunner{


    @Test
    public void selectOneWine() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");

        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();

        /////////

        // Navigate to “Cocktails” page
        mainPage.clickOnCoctailPagelinkOnMainPage();

 CoctailPage coctailPage = new CoctailPage(driver);

        coctailPage.clickOnToggleRedOnCoctailPage();
        //close dropdown
        coctailPage.closeDropdownOnCoctailPage();

        //Verify that 7 recipes are displayed
        Thread.sleep(2000);
        Assertions.assertEquals(7,coctailPage.numberOfCoctailsDisplayed());
    }

}