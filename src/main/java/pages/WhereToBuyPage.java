package pages;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
