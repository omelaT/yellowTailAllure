package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoctailIngredientPage extends AbstractPage {

    public CoctailIngredientPage () {
        super();
    }

    @FindBy(css ="[class=\"recipe-intro\"]")
    private WebElement ingridientSection;

    public  boolean ingridientSectionIsDisplayed(){
        return ingridientSection.isDisplayed();
    }

}
