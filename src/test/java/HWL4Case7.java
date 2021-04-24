import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import java.util.Set;

public class HWL4Case7 {

    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver");
        driver = new ChromeDriver();
        // получаем набор дескрипторов текущих открытых окон

    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void mainPageGlobalNavLogic() throws InterruptedException {
        driver.get("https://www.yellowtailwine.com");
        Set<String> oldWindowsSet = driver.getWindowHandles();
        //precondition
        //check checkbox
        WebElement checkbox = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        checkbox.click();
        //choose europe
        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByVisibleText("Europe");
        // Welcome button click
        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=\"Welcome\"]"));
        welcomeButton.click();
        // check that we ere on the main page
        WebElement mainpage = driver.findElement(By.cssSelector(".large-mobile"));
        Assertions.assertTrue(mainpage.isDisplayed());

        //Click on Menu button
        WebElement menuButton = driver.findElement(By.cssSelector(".fa.fa-bars"));
        menuButton.click();
        Thread.sleep(2000);

        //Click on Globe icon
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.fa.fa-globe.fa-lg',':before').click();");

        //Select China
        WebElement chinaButton = driver.findElement(By.cssSelector("[data-key=\"CN\"]"));
        chinaButton.click();
        Thread.sleep(10000);


        //. Click on icon ( in white square on screenshot)
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.querySelector('.fa.fa-weibo',':before').click();");
        Thread.sleep(11000);

        //Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
// получаем новый набор дескрипторов, включающий уже и новое окно
        Set<String> newWindowsSet = driver.getWindowHandles();

// получаем дескриптор нового окна
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();

        driver.switchTo().window(newWindowHandle);
        System.out.println("New window title: " + driver.getTitle());

        Assertions.assertTrue(driver.getCurrentUrl().contains("yellowtailChina"));
        driver.close();


    }
}