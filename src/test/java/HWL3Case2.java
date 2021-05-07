import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;

public class HWL3Case2  extends JunitRunner{

    @Test
    public void navigateAsCustomer() {
        WelcomePage welcomePage = new WelcomePage();

        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();

        MainPage mainPage = new MainPage();
        Assertions.assertTrue(DriverProvider.getDriver().getCurrentUrl().contains("https://www.yellowtailwine.com/"));


    }


}
