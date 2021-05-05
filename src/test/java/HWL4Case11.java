import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CoctailPage;
import pages.MainPage;
import pages.WelcomePage;

public class HWL4Case11 extends JunitRunner {



    @Test
    public void selectSeveralWines() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        //precondition
        //check checkbox
        //precondition
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.verifyThisIsMainPage());
        // Click on Menu button
        mainPage.clickOnMenuButtonOnMainPage();
        ///////////////////////////////////////

        // Navigate to “Cocktails” page
        mainPage.clickOnCoctailPagelinkOnMainPage();
        CoctailPage coctailPage = new CoctailPage(driver);


        //  Select “Red wine cocktails”
        //1 click toggle .toggle
        coctailPage.clickOnToggleRedOnCoctailPage();

       // Select “Sparkling wine cocktails”
        coctailPage.clickOnToggleSparclingRedOnCoctailPage();

        //close dropdown
       coctailPage.closeDropdownOnCoctailPage();

        //4. Verify that “Multiple” word is displayed in “Type” dropdown
        //aria-label="Type - select to access the drop down menu of wine types"
        WebElement categoryMultiple = driver.findElement(By.cssSelector("[aria-label*=\"Type \"]"));

        Assertions.assertTrue(coctailPage.multipleIsDisplayedOnCoctailPage().contains("Multiple"));

        //5. Verify that 18 recipes are displayed
     //   int count = driver.findElements(By.cssSelector("[class=\"tile recipe-tile\"]")).size();
      //  System.out.println(count);
     //   Assertions.assertEquals(18,count);
        Thread.sleep(2000);
        Assertions.assertEquals(18,coctailPage.numberOfCoctailsDisplayed());
}
}