import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

public class HWL4Case10  extends  JunitRunner{

    @Test
    public void navigateToCocktailRecipePage() throws InterruptedException {
        DriverProvider.getDriver().get("https://www.yellowtailwine.com");
        //precondition
        //precondition
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();


        //////

        // Navigate to “Cocktails” page
        mainPage.clickOnCoctailPagelinkOnMainPage();
        CoctailPage coctailPage = new CoctailPage();

        coctailPage.scroleToRoseAndClickOnItOnCoctailPage();
        CoctailIngredientPage coctailIngredientPage = new CoctailIngredientPage();

        coctailIngredientPage.ingridientSectionIsDisplayed();

    }
}