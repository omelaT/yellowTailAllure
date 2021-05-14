package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoctailIngredientPage extends AbstractPage {

    public CoctailIngredientPage() {
        super();
    }

    @FindBy(css = "[class=\"recipe-intro\"]")
    private WebElement ingridientSection;

    @Step(" ingridients section displayed")
    public boolean ingridientSectionIsDisplayed() {
        return ingridientSection.isDisplayed();
    }

}
