import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WelcomePage;

public class HWL3Case2  extends JunitRunner{

    @Test
    public void navigateAsCustomer() {
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.yellowtailwine.com/"));


    }


}
