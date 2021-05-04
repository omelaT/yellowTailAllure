import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class WeiboComMainPage {
    static WebDriver driver;

    public WeiboComMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
 //   public static void verifyWeiboComIsOpened(){
       // Assertions.assertTrue(driver.getCurrentUrl().contains("yellowtailChina"));
  //  }
 public void newPageWeiboIsOpened(){
     Set<String> oldWindowsSet = driver.getWindowHandles();
     // получаем новый набор дескрипторов, включающий уже и новое окно
     Set<String> newWindowsSet = driver.getWindowHandles();

// получаем дескриптор нового окна

     newWindowsSet.removeAll(oldWindowsSet);
     String newWindowHandle = newWindowsSet.iterator().next();

     driver.switchTo().window(newWindowHandle);
     System.out.println("New window title: " + driver.getTitle());
     //    Assertions.assertTrue(driver.getCurrentUrl().contains("yellowtailChina"));
     driver.close();

 }
}
