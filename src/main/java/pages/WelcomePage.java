package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage extends  AbstractPage {
   //  WebDriver driver;

    public WelcomePage() {
        super();
    }



    @FindBy(css = "[for=\"confirm\"]")
    private WebElement text;
    @FindBy(css = "[for=\"confirm\"]")
    private WebElement checkbox;
    @FindBy(css = ".agegate-selector-options")
    private WebElement select;
    @FindBy(css = "[value=\"Welcome\"]")
    private WebElement welcomeButton;
    @FindBy(css = "[value=\"Welcome\"]")
    private WebElement welcomeButtonInactive;
    @FindBy(css = "[for=\"confirm\"]")
    private WebElement checkboxClick;
    @FindBy(css = ".agegate-selector-options")
    private WebElement selectEuropFromDropdown;
    @FindBy(css = "[value=\"Welcome\"]")
    private WebElement clickOnWelcomeButton;

    public boolean legalTextDisplayedOnWelcomePage() {
        return text.getText().contains("I am of legal drinking age in");
    }

    public boolean checkboxTextDisplayedOnWelcomePage() {
        return checkbox.isDisplayed();
    }

    public boolean selectIsDispalyedOnWelcomePage() {
        return select.isDisplayed();
    }

    public boolean welcomeButtonIsDispalyedOnWelcomePage() {
        return welcomeButton.isDisplayed();
    }

    public boolean welcomeButtonIsInactiveOnWelcomePage() {
        return welcomeButtonInactive.isEnabled();
    }

    public MainPage checkboxClickEuropeSelectWelcomeBttonClick() {
        checkboxClick.click();
        Select selectEuropFromDropdown = new Select(select);
        selectEuropFromDropdown.selectByVisibleText("Europe");
        clickOnWelcomeButton.click();
        return new MainPage();
    }

}
