package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage extends AbstractPage {

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

    @Step("legal Text Displayed On WelcomePage")
    public boolean legalTextDisplayedOnWelcomePage() {
        return text.getText().contains("I am of legal drinking age in");
    }

    @Step("checkbox Text Displayed On WelcomePage")
    public boolean checkboxTextDisplayedOnWelcomePage() {
        return checkbox.isDisplayed();
    }

    @Step("select Is Dispalyed On WelcomePage")
    public boolean selectIsDispalyedOnWelcomePage() {
        return select.isDisplayed();
    }

    @Step("welcome Button Is Dispalyed On WelcomePag")
    public boolean welcomeButtonIsDispalyedOnWelcomePage() {
        return welcomeButton.isDisplayed();
    }

    @Step("welcome Button Is Inactive On WelcomePage")
    public boolean welcomeButtonIsInactiveOnWelcomePage() {
        return welcomeButtonInactive.isEnabled();
    }

    @Step("checkbox Click Europe Select Welcome Btton Click")
    public MainPage checkboxClickEuropeSelectWelcomeBttonClick() {
        checkboxClick.click();
        Select selectEuropFromDropdown = new Select(select);
        selectEuropFromDropdown.selectByVisibleText("Europe");
        clickOnWelcomeButton.click();
        return new MainPage();
    }

}
