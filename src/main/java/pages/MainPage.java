package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class MainPage extends AbstractPage {

    public MainPage() {
        super();

    }

    @FindBy(css = ".large-mobile")
    private WebElement thisIsMainPage;
    @FindBy(css = ".fa.fa-bars")
    private WebElement menubuttonOnMainPageDisplayed;
    @FindBy(css = "[class = \"content animation-screen -one\"] h2")
    private WebElement titleOnMainPage;
    @FindBy(css = "[class=\"content animation-screen -one\"] p")
    private WebElement passionateText;
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
    @FindBy(css = "[href*=\"stores\"]")
    private WebElement storesLink;
    @FindBy(css = "[href*=\"cocktails\"]")
    private WebElement coctailsLink;
    @FindBy(css = "[href*=\"our-story\"]")
    private WebElement ourStoryLink;
    @FindBy(css = "[href*=\"faqs\"]")
    private WebElement faqsLink;
    @FindBy(css = "[href*=\"contact\"]")
    private WebElement contactLink;
    @FindBy(css = "[class=\"yt-logo\"] img[src*=\"logo-yellowtail-white.svg\"]")
    private WebElement logoOnMainPage;
    @FindBy(css = ".fa.fa-bars")
    private WebElement menuButtonOnMainPage;
    @FindBy(css = "[class=\"yt-logo\"] img[src*=\"logo-yellowtail-white.svg\"]")
    private WebElement clickOnYellowTail;
    @FindBy(css = ".fa.fa-globe.fa-lg")
    private WebElement globeIcon;
    @FindBy(css = "[data-key=\"CN\"]")
    private WebElement selectChina;
    @FindBy(css = "[class=\"sgg-comp-button-inner\"]")
    private WebElement findYourWineButtonChangeLang;
    @FindBy(css = "[href*=\"stores\"]")
    private WebElement whereToBueMenu;
    @FindBy(css = "[href*=\"cocktails\"]")
    private WebElement coctails;

    @FindBy(css = ".fa.fa-weibo")
    private WebElement weibo;

@Step("this is main page")
    public boolean verifyThisIsMainPage() {
        return thisIsMainPage.isDisplayed();
    }
@Step("menu button displayed")
    public boolean menuButtonIsDisplayedOnMainPage() {
        return menubuttonOnMainPageDisplayed.isDisplayed();
    }
@Step("title on main page")
    public boolean titleOnMainPageIsDisplayed() {
        return titleOnMainPage.isDisplayed();
    }
@Step("passionate text displayed")
    public boolean passionateTextIsDisplayedOnMainPage() {
        return passionateText.isDisplayed();
    }
@Step("enjoi text displayed")
    public boolean enjoyTextIsDisplayedOnMainPage() {
        return enjoyText.isDisplayed();
    }
@Step("find your vine button displayed")
    public boolean findYourWineButtonIsDisplayedOnMainPage() {
        return findYourWineButton.isDisplayed();
    }
@Step("check footer")
    public boolean footerOnOnMainPage() {
        return findYourWineButton.isDisplayed();
    }
@Step("click on Menu button")
    public void clickOnMenuButtonOnMainPage() {
        clickOnMenuButton.click();
    }
@Step("Wine link on main page")
    public boolean wineLinkDisplayedOnMainPage() {
        return wineLink.isDisplayed();
    }
@Step("stores link on main page")
    public boolean storesLinkDisplayedOnMainPage() {
        return storesLink.isDisplayed();
    }
@Step("coctails link on main page")
    public boolean coctailsLinkDisplayedOnMainPage() {
        return coctailsLink.isDisplayed();
    }
@Step("our story link on main page")
    public boolean ourStoryLinkDisplayedOnMainPage() {
        return ourStoryLink.isDisplayed();
    }
@Step("faqs link on main page")
    public boolean faqsLinkDisplayedOnMainPage() {
        return faqsLink.isDisplayed();
    }
@Step("contacts link on main page")
    public boolean contactLinkDisplayedOnMainPage() {
        return contactLink.isDisplayed();
    }
@Step("click on logo on main page")
    public void clickOnLogoOnMainPage() {
        logoOnMainPage.click();
    }
@Step("click on menu button")
    public void menuButtonClickOnMainPage() {
        menuButtonOnMainPage.click();
    }
@Step("click on Yellow TAil")
    public void clickOnYellowTailOnMainPage() {
        clickOnYellowTail.click();
    }
@Step("globe icon is visible")
    public boolean globeIconIsVisible() {
        return globeIcon.isDisplayed();
    }
@Step("click on The globe")
    public void clickOnTheGlobeIcon() {
        JavascriptExecutor js = (JavascriptExecutor) DriverProvider.INSTANCE.getDriver();
        js.executeScript("document.querySelector('.fa.fa-globe.fa-lg',':before').click();");
    }

@Step(" Select China")
    public WeiboComMainPage selectChinaAndClick() {
        selectChina.click();
        return new WeiboComMainPage();
    }
@Step("language is changed")
    public String getChangedLanguageOnFindYourWineButton() {
        return findYourWineButtonChangeLang.getText();
    }
@Step("click on redirect  Icon")
    public WeiboComMainPage clickOnRedirectIcon() {
        JavascriptExecutor js1 = (JavascriptExecutor) DriverProvider.INSTANCE.getDriver();
        js1.executeScript("document.querySelector('.fa.fa-weibo',':before').click();");
        return new WeiboComMainPage();
    }
@Step("click on whre to by link")
    public WhereToBuyPage whereToByMenuClick() {
        whereToBueMenu.click();
        return new WhereToBuyPage();
    }
@Step("click on  coctail link")
    public CoctailPage clickOnCoctailPagelinkOnMainPage() {
        coctails.click();
        return new CoctailPage();
    }
//waiters
@Step("wait ForGlobeIcon")
    public void waitForGlobeIcon() {
        Waiters.waitingForTheElementToBeVisible(globeIcon);
    }

    public void waitForIconAfterChinaSelected() {
        Waiters.waitingForTheElementToBeVisible(weibo);
    }

    public void waitForMenuButton() {
        Waiters.waitingForTheElementToBeVisible(logoOnMainPage);
    }

    public void waitForElementChina() {
        Waiters.waitingForTheElementToBeVisible(selectChina);
    }

    public void waitTime() {
        Waiters.waitingForTheElementToBeVisible(selectChina);
    }

}
