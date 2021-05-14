package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WeiboComMainPage extends AbstractPage {
    public WeiboComMainPage() {
        super();
    }


    public void getDescription(Set<String> oldWindowsSet) {

        Set<String> newWindowsSet = DriverProvider.INSTANCE.getDriver().getWindowHandles();
        // получаем дескриптор нового окна

        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        DriverProvider.INSTANCE.getDriver().switchTo().window(newWindowHandle);
        System.out.println("New window title: " + DriverProvider.INSTANCE.getDriver().getTitle());
    }

    //wait
    @Step("wait For WeiboPage")
    public void waitForWeiboPage() {
        (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(30))).
                until(ExpectedConditions.urlContains("weibo"));

    }

    @Step("wait For WeiboPageLoad")
    public void waitForWeiboPageLoad() {
        new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(30));

    }


}
