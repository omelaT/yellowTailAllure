import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoctailPage {
    WebDriver driver;

    public CoctailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css =".toggle" )
    private WebElement toggleRed;
    public void clickOnToggleRedOnCoctailPage(){
        toggleRed.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('[data-value=\"red\"]',':before').click();");
    }
    @FindBy(css =".toggle" )
    private WebElement toggleSparcling;
    public void clickOnToggleSparclingRedOnCoctailPage(){
        toggleRed.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('[data-value=\"bubbles\"]',':before').click();");
    }

        @FindBy(css = ".toggle" )
        private WebElement closeDropdown;
        public void closeDropdownOnCoctailPage(){
            closeDropdown.click();

        }

        @FindBy(css = "[alt=\"Raspberry Rose\"]")
        private WebElement raspberryRose;
        public  void scroleToRoseAndClickOnItOnCoctailPage(){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", raspberryRose);
            raspberryRose.click();
        }




        @FindBy(css = "[aria-label*=\"Type \"]")
        private WebElement  categoryMultiple;
        public String  multipleIsDisplayedOnCoctailPage(){
          return  categoryMultiple.getText();
        }

        @FindBy(css =("[class=\"tile recipe-tile\"]") )
        private WebElement countCoctail;
        public Dimension numberOfCoctailsDisplayed(){
            return countCoctail.getSize();
        }


}
