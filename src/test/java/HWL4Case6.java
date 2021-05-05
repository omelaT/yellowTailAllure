import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case6 extends JunitRunner{

    @Test
    public void requirenmentElementsDisplayedOnMainPage() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());

        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();

        //Click on Globe icon
        mainPage.clickOnTheGlobeIcon();

        //Select China
        mainPage.selectChinaAndClick();
        System.out.println("success click");
        // Verify that language is changed
        //- find your wine button
       // WebElement findYourWineButton = driver.findElement(By.cssSelector("[class=\"sgg-comp-button-inner\"]"));
        Assertions.assertTrue( mainPage.getChangedLanguageOnFindYourWineButton().contains("发现适合你的酒"));
        System.out.println("success");
    }
}