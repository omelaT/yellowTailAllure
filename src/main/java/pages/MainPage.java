package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;


public class MainPage extends  AbstractPage {

    public MainPage () {
        super();

    }

    @FindBy(css = ".large-mobile")
    private WebElement thisIsMainPage;
    @FindBy(css = ".fa.fa-bars")
    private  WebElement menubuttonOnMainPageDisplayed;
    @FindBy(css ="[class = \"content animation-screen -one\"] h2" )
    private WebElement titleOnMainPage;
    @FindBy(css ="[class=\"content animation-screen -one\"] p" )
    private WebElement  passionateText;
    @FindBy(css = "[class=\"content animation-screen -one\"] p")
    private WebElement enjoyText;
    @FindBy(css = "[class=\"content animation-screen -one\"]> a")
    private WebElement findYourWineButton;
    @FindBy(css = ".primary-footer")
    private WebElement footer;
    @FindBy(css = ".fa.fa-bars")
    private WebElement clickOnMenuButton;
    @FindBy(css = "[href*=\"wines\"]")
    private WebElement wineLink;
    @FindBy(css ="[href*=\"stores\"]")
    private WebElement storesLink;
    @FindBy(css ="[href*=\"cocktails\"]")
    private WebElement coctailsLink;
    @FindBy(css ="[href*=\"our-story\"]")
    private WebElement ourStoryLink;
    @FindBy(css ="[href*=\"faqs\"]")
    private WebElement faqsLink;
    @FindBy(css ="[href*=\"contact\"]")
    private WebElement contactLink;
    @FindBy(css ="[class=\"yt-logo\"] img[src*=\"logo-yellowtail-white.svg\"]" )
    private WebElement logoOnMainPage;
    @FindBy(css =".fa.fa-bars" )
    private WebElement menuButtonOnMainPage;
    @FindBy(css ="[class=\"yt-logo\"] img[src*=\"logo-yellowtail-white.svg\"]" )
    private WebElement clickOnYellowTail;
    @FindBy(css = ".fa.fa-globe.fa-lg")
    private WebElement globeIcon;
    @FindBy(css = "[data-key=\"CN\"]")
    private WebElement selectChina;
    @FindBy(css ="[class=\"sgg-comp-button-inner\"]" )
    private WebElement findYourWineButtonChangeLang;
    @FindBy(css ="[href*=\"stores\"]" )
    private WebElement whereToBueMenu;
    @FindBy(css = "[href*=\"cocktails\"]")
    private WebElement coctails;

    @FindBy(css = ".fa.fa-weibo")
    private WebElement weibo;


    public boolean verifyThisIsMainPage(){
        return thisIsMainPage.isDisplayed();
    }

    public boolean menuButtonIsDisplayedOnMainPage(){
        return menubuttonOnMainPageDisplayed.isDisplayed();
    }

    public boolean titleOnMainPageIsDisplayed(){
        return titleOnMainPage.isDisplayed();
    }

    public boolean passionateTextIsDisplayedOnMainPage(){
     return   passionateText.isDisplayed();
    }

    public boolean enjoyTextIsDisplayedOnMainPage(){
        return enjoyText.isDisplayed();
    }

    public boolean findYourWineButtonIsDisplayedOnMainPage(){
      return findYourWineButton.isDisplayed();
    }

    public boolean footerOnOnMainPage(){
        return findYourWineButton.isDisplayed();
    }

    public void clickOnMenuButtonOnMainPage(){
        clickOnMenuButton.click();
    }

    public boolean wineLinkDisplayedOnMainPage(){
        return wineLink.isDisplayed();
    }
    public boolean storesLinkDisplayedOnMainPage(){
        return storesLink.isDisplayed();
    }

    public boolean coctailsLinkDisplayedOnMainPage(){
        return coctailsLink.isDisplayed();
    }

    public boolean ourStoryLinkDisplayedOnMainPage(){
        return ourStoryLink.isDisplayed();
    }

    public boolean faqsLinkDisplayedOnMainPage(){
        return faqsLink.isDisplayed();
    }

    public boolean contactLinkDisplayedOnMainPage(){
        return contactLink.isDisplayed();
    }

    public void clickOnLogoOnMainPage(){
        logoOnMainPage.click();
    }

    public void menuButtonClickOnMainPage(){
        menuButtonOnMainPage.click();

    }

    public void clickOnYellowTailOnMainPage(){
        clickOnYellowTail.click();
    }

    //////

    public boolean globeIconIsVisible(){
        return globeIcon.isDisplayed();
    }

    public void clickOnTheGlobeIcon(){
        JavascriptExecutor js = (JavascriptExecutor) DriverProvider.INSTANCE.getDriver() ;
        js.executeScript("document.querySelector('.fa.fa-globe.fa-lg',':before').click();");
    }
    //Select China

    public WeiboComMainPage selectChinaAndClick() {
        selectChina.click();
        return new WeiboComMainPage();
    }

    public String getChangedLanguageOnFindYourWineButton(){
        return findYourWineButtonChangeLang.getText();
    }

    public void clickOnRedirectIcon(){
        JavascriptExecutor js1 = (JavascriptExecutor) DriverProvider.INSTANCE.getDriver();
        js1.executeScript("document.querySelector('.fa.fa-weibo',':before').click();");
    }

        public WhereToBuyPage whereToByMenuClick(){
            whereToBueMenu.click();
            return new WhereToBuyPage();
        }

    public CoctailPage clickOnCoctailPagelinkOnMainPage(){
        coctails.click();
        return new CoctailPage();
        }

    //ожидания

    public void waitForGlobeIcon() {
       Waiters.waitingForTheElementToBeVisible(globeIcon);
      //  Waiters.waitingForTheElementToBeVisible(weibo);
     //   Waiters.waitingForTheElementToBeVisible(logoOnMainPage);
     //   Waiters.waitingForTheElementToBeVisible(selectChina);
    }
    public void waitForIconAfterChinaSelected(){
        Waiters.waitingForTheElementToBeVisible(weibo);
    }
    public void waitForMenuButton(){
        Waiters.waitingForTheElementToBeVisible(logoOnMainPage);
    }
    public void waitForElementChina(){
        Waiters.waitingForTheElementToBeVisible(selectChina);
    }
    public void waitTime(){
        Waiters.waitingForTheElementToBeVisible(selectChina);
    }



/*
   public void waitForGlobeIcon(){
       new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(globeIcon));
    }

    public void waitForIconAfterChinaSelected(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOf(weibo));
              //  until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fa.fa-weibo")));
    }
   public void waitForMenuButton(){

        new WebDriverWait(driver , Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(logoOnMainPage));
              //  until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fa.fa-bars")));
    }
    public void waitForElementChina(){
        new WebDriverWait(driver , Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(selectChina));
    }

    public void waitForNewPage(){
        new WebDriverWait(DriverProvider.getDriver() , Duration.ofSeconds(20));
    }
*/





}
