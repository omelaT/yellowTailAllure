import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

public class HWL4Case10  extends  JunitRunner{
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")

    @Test
    public void navigateToCocktailRecipePage() throws InterruptedException {
        DriverProvider.INSTANCE.getDriver().get("https://www.yellowtailwine.com");
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

        coctailPage.scroleToRoseAndClickOnItOnCoctailPage();
        CoctailIngredientPage coctailIngredientPage = new CoctailIngredientPage();
        makeScreenshot();

        coctailIngredientPage.ingridientSectionIsDisplayed();

    }
}