import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WelcomePage;


public class HWL3Case5 extends JunitRunner{


    @Test
    public void menuButtonLogic() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        WelcomePage welcomePage = new WelcomePage(driver);

        //precondition
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());

        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();

        //Click on [yellow tail]
       mainPage.clickOnYellowTailOnMainPage();

        //Verify that Menu button is visible
      Assertions.assertTrue(mainPage.menuButtonIsDisplayedOnMainPage());
        System.out.println("success");


    }
}
