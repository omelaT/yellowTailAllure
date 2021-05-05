import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WelcomePage;

public class HWL3Case4 extends JunitRunner {


    @Test
    public void menuButtonLogic() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        driver.get("https://www.yellowtailwine.com");
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        // check that we ere on the main page
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        System.out.println("mainPage");

        //2. Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();
        System.out.println("clickonmenubutton");
        Thread.sleep(2000);

       //Verify that header with all needed links is appeared
        Assertions.assertTrue(mainPage.wineLinkDisplayedOnMainPage());
        System.out.println("link 1 exists");
        Assertions.assertTrue(mainPage.storesLinkDisplayedOnMainPage());
        System.out.println("link 2 exists");
        Assertions.assertTrue(mainPage.coctailsLinkDisplayedOnMainPage());
        System.out.println("link 3 exists");
        Assertions.assertTrue(mainPage.ourStoryLinkDisplayedOnMainPage());
        System.out.println("link 4 exists");
        Assertions.assertTrue(mainPage.faqsLinkDisplayedOnMainPage());
        System.out.println("link 5 exists");
        Assertions.assertTrue(mainPage.contactLinkDisplayedOnMainPage());
        System.out.println("links exists");

        //  4. Click on [yellow tail]
        mainPage.clickOnLogoOnMainPage();
        //  5. Verify that Menu button is visible
        mainPage.menuButtonClickOnMainPage();

        System.out.println("test success");

    }
}




