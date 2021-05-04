import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
    static WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement text;

    public boolean legalTextDisplayedOnWelcomePage() {
        return text.getText().contains("I am of legal drinking age in");
    }

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement checkbox;

    public boolean checkboxTextDisplayedOnWelcomePage() {
        return checkbox.isDisplayed();
    }

    @FindBy(css = ".agegate-selector-options")
    private WebElement select;

    public boolean selectIsDispalyedOnWelcomePage() {
        return select.isDisplayed();
    }

    @FindBy(css = "[value=\"Welcome\"]")
    private WebElement welcomeButton;

    public boolean welcomeButtonIsDispalyedOnWelcomePage() {
        return welcomeButton.isDisplayed();
    }

    @FindBy(css = "[value=\"Welcome\"]")
    private WebElement welcomeButtonInactive;

    public boolean welcomeButtonIsInactiveOnWelcomePage() {
        return welcomeButtonInactive.isEnabled();
    }

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement checkboxClick;
    @FindBy(css = ".agegate-selector-options")
    private WebElement selectEuropFromDropdown;
    @FindBy(css = "[value=\"Welcome\"]")
    private WebElement clickOnWelcomeButton;

    public void checkboxClickEuropeSelectWelcomeBttonClick() {
        checkboxClick.click();
        Select selectEuropFromDropdown = new Select(select);
        selectEuropFromDropdown.selectByVisibleText("Europe");
        clickOnWelcomeButton.click();
    }

}
