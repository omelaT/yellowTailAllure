package pages;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".large-mobile")
    private WebElement thisIsMainPage;
    public boolean verifyThisIsMainPage(){
        return thisIsMainPage.isDisplayed();
    }

    @FindBy(css = ".fa.fa-bars")
    private  WebElement menubuttonOnMainPageDisplayed;
    public boolean menuButtonIsDisplayedOnMainPage(){
        return menubuttonOnMainPageDisplayed.isDisplayed();
    }

    @FindBy(css ="[class = \"content animation-screen -one\"] h2" )
    private WebElement titleOnMainPage;
    public boolean titleOnMainPageIsDisplayed(){
        return titleOnMainPage.isDisplayed();
    }

    @FindBy(css ="[class=\"content animation-screen -one\"] p" )
    private WebElement  passionateText;
    public boolean passionateTextIsDisplayedOnMainPage(){
     return   passionateText.isDisplayed();
    }

    @FindBy(css = "[class=\"content animation-screen -one\"] p")
    private WebElement enjoyText;
    public boolean enjoyTextIsDisplayedOnMainPage(){
        return enjoyText.isDisplayed();
    }
    @FindBy(css = "[class=\"content animation-screen -one\"]> a")
    private WebElement findYourWineButton;
    public boolean findYourWineButtonIsDisplayedOnMainPage(){
      return findYourWineButton.isDisplayed();
    }
    @FindBy(css = ".primary-footer")
    private WebElement footer;
    public boolean footerOnOnMainPage(){
        return findYourWineButton.isDisplayed();
    }

    @FindBy(css = ".fa.fa-bars")
    private WebElement clickOnMenuButton;
    public void clickOnMenuButtonOnMainPage(){
        clickOnMenuButton.click();
    }

    @FindBy(css = "[href*=\"wines\"]")
    private WebElement wineLink;
    public boolean wineLinkDisplayedOnMainPage(){
        return wineLink.isDisplayed();
    }

    @FindBy(css ="[href*=\"stores\"]")
    private WebElement storesLink;
    public boolean storesLinkDisplayedOnMainPage(){
        return storesLink.isDisplayed();
    }

    @FindBy(css ="[href*=\"cocktails\"]")
    private WebElement coctailsLink;
    public boolean coctailsLinkDisplayedOnMainPage(){
        return coctailsLink.isDisplayed();
    }

    @FindBy(css ="[href*=\"our-story\"]")
    private WebElement ourStoryLink;
    public boolean ourStoryLinkDisplayedOnMainPage(){
        return ourStoryLink.isDisplayed();
    }

    @FindBy(css ="[href*=\"faqs\"]")
    private WebElement faqsLink;
    public boolean faqsLinkDisplayedOnMainPage(){
        return faqsLink.isDisplayed();
    }

    @FindBy(css ="[href*=\"contact\"]")
    private WebElement contactLink;
    public boolean contactLinkDisplayedOnMainPage(){
        return contactLink.isDisplayed();
    }
    @FindBy(css ="[class=\"yt-logo\"] img[src*=\"logo-yellowtail-white.svg\"]" )
    private WebElement logoOnMainPage;
    public void clickOnLogoOnMainPage(){
        logoOnMainPage.click();
    }

    @FindBy(css =".fa.fa-bars" )
    private WebElement menuButtonOnMainPage;
    public void menuButtonClickOnMainPage(){
        menuButtonOnMainPage.click();
    }

    @FindBy(css ="[class=\"yt-logo\"] img[src*=\"logo-yellowtail-white.svg\"]" )
    private WebElement clickOnYellowTail;
    public void clickOnYellowTailOnMainPage(){
        clickOnYellowTail.click();
    }

    //////
    @FindBy(css = ".fa.fa-globe.fa-lg")
    private WebElement globeIcon;
    public boolean globeIconIsVisible(){
        return globeIcon.isDisplayed();
    }

    public void clickOnTheGlobeIcon(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.fa.fa-globe.fa-lg',':before').click();");
    }
    //Select China
@FindBy(css = "[data-key=\"CN\"]")
private WebElement selectChina;
    public void selectChinaAndClick() {
        selectChina.click();
    }


    @FindBy(css ="[class=\"sgg-comp-button-inner\"]" )
    private WebElement findYourWineButtonChangeLang;
    public String getChangedLanguageOnFindYourWineButton(){
        return findYourWineButtonChangeLang.getText();
    }

    public void clickOnIconAfterChinaSelected(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.querySelector('.fa.fa-weibo',':before').click();");
    }

        @FindBy(css ="[href*=\"stores\"]" )
        private WebElement whereToBueMenu;
        public void whereToByMenuClick(){
            whereToBueMenu.click();

        }

        @FindBy(css = "[href*=\"cocktails\"]")
        private WebElement coctails;
    public void clickOnCoctailPagelinkOnMainPage(){
        coctails.click();

        }
        //ожидания
    public void waitForGlobeIcon(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(globeIcon));
    }



}
