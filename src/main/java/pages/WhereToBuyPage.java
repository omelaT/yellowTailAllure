package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhereToBuyPage {
    WebDriver driver;

    public WhereToBuyPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

        @FindBy(css ="[id=\"locationName\"]" )
        private WebElement locationField;
        public void locationFieldOnWhereToBuyPage(){
            locationField.sendKeys("Kiev Street, Merrylands NSW, Australia");
            locationField.sendKeys(Keys.ENTER);
        }

        @FindBy(css =".search-submit" )
        private WebElement clickOnSearch;
        public void clickOnSearchButtonOnWhereToBuyPage(){
            clickOnSearch.click();
        }
        @FindBy(css ="[class=\"tile\"]:first-child" )
        private WebElement searchResult;
        public boolean searchResultOnWhereToBuyPage(){
          return  searchResult.isDisplayed();

        }


}
