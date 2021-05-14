package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CoctailPage extends AbstractPage {

    public CoctailPage() {
        super();
    }

    @FindBy(css = ".toggle")
    private WebElement toggleRed;
    @FindBy(css = ".toggle")
    private WebElement toggleSparcling;
    @FindBy(css = ".toggle")
    private WebElement closeDropdown;
    @FindBy(css = "[alt=\"Raspberry Rose\"]")
    private WebElement raspberryRose;
    @FindBy(css = "[aria-label*=\"Type \"]")
    private WebElement categoryMultiple;
    @FindBy(css = ("[class=\"tile recipe-tile\"]"))
    private WebElement countCoctail;
@Step("click On Toggle Red On CoctailPage")
    public void clickOnToggleRedOnCoctailPage() {
        toggleRed.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverProvider.INSTANCE.getDriver();
        js.executeScript("document.querySelector('[data-value=\"red\"]',':before').click();");
    }
@Step("Sparcling and red ")
    public void clickOnToggleSparclingRedOnCoctailPage() {
        toggleRed.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverProvider.INSTANCE.getDriver();
        js.executeScript("document.querySelector('[data-value=\"bubbles\"]',':before').click();");
    }
@Step("close dropdown")
    public void closeDropdownOnCoctailPage() {
        closeDropdown.click();
    }
@Step("scrole")
    public CoctailIngredientPage scroleToRoseAndClickOnItOnCoctailPage() {
        ((JavascriptExecutor) DriverProvider.INSTANCE.getDriver()).executeScript("arguments[0].scrollIntoView(true);", raspberryRose);
        raspberryRose.click();
        return new CoctailIngredientPage();
    }
@Step("multiple wine displayed")
    public String multipleIsDisplayedOnCoctailPage() {
        return categoryMultiple.getText();
    }

}
