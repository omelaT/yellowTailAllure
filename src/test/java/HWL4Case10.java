import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CoctailIngredientPage;
import pages.CoctailPage;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case10  extends  JunitRunner{

    @Test
    public void navigateToCocktailRecipePage() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();


        //////

        // Navigate to “Cocktails” page
        mainPage.clickOnCoctailPagelinkOnMainPage();
        CoctailPage coctailPage = new CoctailPage(driver);

        coctailPage.scroleToRoseAndClickOnItOnCoctailPage();
        CoctailIngredientPage coctailIngredientPage = new CoctailIngredientPage(driver);

        coctailIngredientPage.ingridientSectionIsDisplayed();

    }
}