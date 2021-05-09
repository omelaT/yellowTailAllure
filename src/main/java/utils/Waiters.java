package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DriverProvider;

import java.time.Duration;

public class Waiters {
    public static WebElement waitingForTheElementToBeVisible(WebElement webElement){
        return (  new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(22)).
               until(ExpectedConditions.visibilityOf(webElement)));
    }
  /*  public static  WebElement waitTime(WebElement webElement){
return (new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(20)));

    }
*/

}
