import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CoctailPage;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case9  extends JunitRunner{


    @Test
    public void selectOneWine() throws InterruptedException {
        DriverProvider.getDriver().get("https://www.yellowtailwine.com");

        //precondition
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();


        // Navigate to “Cocktails” page
        mainPage.clickOnCoctailPagelinkOnMainPage();

 CoctailPage coctailPage = new CoctailPage();

        coctailPage.clickOnToggleRedOnCoctailPage();
        //close dropdown
        coctailPage.closeDropdownOnCoctailPage();

        //Verify that 7 recipes are displayed
       // int coctailNumber = 7;
      //  Assertions.assertEquals(coctailNumber,coctailPage.numberOfCoctailsDisplayed());
        int count = DriverProvider.getDriver().findElements(By.cssSelector("[class=\"tile recipe-tile\"]")).size();
        System.out.println(count);
        Assertions.assertEquals(7,count);
    }

}