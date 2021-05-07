package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WeiboComMainPage extends AbstractPage {
    // WebDriver driver;
 //   Set<String> oldWindowsSet = driver.getWindowHandles();
    public WeiboComMainPage() {
        super();
    }






    public  void getDescription(Set <String> oldWindowsSet) {

        Set<String> newWindowsSet = DriverProvider.getDriver().getWindowHandles();
        // получаем дескриптор нового окна

        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        DriverProvider.getDriver().switchTo().window(newWindowHandle);
        System.out.println("New window title: " + DriverProvider.getDriver().getTitle());
    }
    //wait
    public void waitForWeiboPage(){
        ( new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(30))).
                until(ExpectedConditions.urlContains("weibo"));

    }
    public void waitForWeiboPageLoad(){
         new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(30));

    }



}
