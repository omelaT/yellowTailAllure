import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DriverProvider;
import pages.MainPage;
import pages.WelcomePage;

public class HWL3Case2 extends JunitRunner {
    @Severity(SeverityLevel.BLOCKER)
    @Description("do preconditions to get to the main mage")

    @Test
    public void navigateAsCustomer() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.checkboxClickEuropeSelectWelcomeBttonClick();
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(DriverProvider.INSTANCE.getDriver().getCurrentUrl().contains("https://www.yellowtailwine.com/"));


    }


}
