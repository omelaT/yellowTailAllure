package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
