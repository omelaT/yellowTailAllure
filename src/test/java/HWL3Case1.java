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

@Step("check 5 elements in this test")
    public void verifyElementsOnWelcomePageIsdisplayed() {
        WelcomePage welcomePage = new WelcomePage();

        Assertions.assertTrue(welcomePage.legalTextDisplayedOnWelcomePage());
    makeScreenshot();
        Assertions.assertTrue(welcomePage.checkboxTextDisplayedOnWelcomePage());
    makeScreenshot();
        Assertions.assertTrue(welcomePage.selectIsDispalyedOnWelcomePage());
    makeScreenshot();
        Assertions.assertTrue(welcomePage.welcomeButtonIsDispalyedOnWelcomePage());
    makeScreenshot();
        Assertions.assertFalse(welcomePage.welcomeButtonIsInactiveOnWelcomePage());



    }

}
