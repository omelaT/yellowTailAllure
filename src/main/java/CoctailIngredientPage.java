import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoctailIngredientPage {
    WebDriver driver;

    public CoctailIngredientPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="[class=\"recipe-intro\"]")
    private WebElement ingridientSection;
    public  boolean ingridientSectionIsDisplayed(){
        return ingridientSection.isDisplayed();
    }

}
