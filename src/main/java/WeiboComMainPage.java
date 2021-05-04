import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.Set;

public class WeiboComMainPage {
     WebDriver driver;
 //   Set<String> oldWindowsSet = driver.getWindowHandles();
    public WeiboComMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  void getDescription(Set <String> oldWindowsSet) {

        Set<String> newWindowsSet = driver.getWindowHandles();
        // получаем дескриптор нового окна

        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
        System.out.println("New window title: " + driver.getTitle());
    }



}
