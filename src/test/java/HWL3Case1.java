import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WelcomePage;
import utils.Constants;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HWL3Case1 extends JunitRunner {


    @Severity(SeverityLevel.BLOCKER)
    @Description("elements on the main page")


    @Test
    public void verifyElementsOnWelcomePageIsdisplayed() {
        WelcomePage welcomePage = new WelcomePage();

        Assertions.assertTrue(welcomePage.legalTextDisplayedOnWelcomePage());
        Assertions.assertTrue(welcomePage.checkboxTextDisplayedOnWelcomePage());
        Assertions.assertTrue(welcomePage.selectIsDispalyedOnWelcomePage());
        Assertions.assertTrue(welcomePage.welcomeButtonIsDispalyedOnWelcomePage());
        Assertions.assertFalse(welcomePage.welcomeButtonIsInactiveOnWelcomePage());


    }

}
