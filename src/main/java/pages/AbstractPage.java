package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage () {

        PageFactory.initElements(DriverProvider.getDriver(),this);

    }
  //  public abstract void waitForLoadingElement();

  /*  public WebElement waitingForTheElementToBeVisible(WebElement webElement){
     return (  new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOf(webElement)));
    }
*/

}
