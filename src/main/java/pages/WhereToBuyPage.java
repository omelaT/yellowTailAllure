package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhereToBuyPage extends AbstractPage {


    public WhereToBuyPage() {
        super();
    }

    @FindBy(css = "[id=\"locationName\"]")
    private WebElement locationField;
    @FindBy(css = ".search-submit")
    private WebElement clickOnSearch;
    @FindBy(css = "[class=\"tile\"]:first-child")
    private WebElement searchResult;

    @Step("location Field On WhereToBuyPage")
    public void locationFieldOnWhereToBuyPage() {
        locationField.sendKeys("Kiev Street, Merrylands NSW, Australia");
        locationField.sendKeys(Keys.ENTER);
    }

    @Step("click On Search Button On WhereToBuyPage")
    public void clickOnSearchButtonOnWhereToBuyPage() {
        clickOnSearch.click();
    }

    @Step("search Result On WhereToBuyPage")
    public boolean searchResultOnWhereToBuyPage() {
        return searchResult.isDisplayed();
    }

}
