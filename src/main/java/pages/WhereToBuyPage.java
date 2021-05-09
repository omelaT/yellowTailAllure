package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhereToBuyPage extends AbstractPage {
  //  WebDriver driver;

    public WhereToBuyPage() {
        super();
    }




    @FindBy(css ="[id=\"locationName\"]" )
        private WebElement locationField;
    @FindBy(css =".search-submit" )
    private WebElement clickOnSearch;
    @FindBy(css ="[class=\"tile\"]:first-child" )
    private WebElement searchResult;

        public void locationFieldOnWhereToBuyPage(){
            locationField.sendKeys("Kiev Street, Merrylands NSW, Australia");
            locationField.sendKeys(Keys.ENTER);
        }

        public void clickOnSearchButtonOnWhereToBuyPage(){
            clickOnSearch.click();
        }

        public boolean searchResultOnWhereToBuyPage(){
          return  searchResult.isDisplayed();
        }


}
