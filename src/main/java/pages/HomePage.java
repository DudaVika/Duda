package pages;

import libs.ConfigClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends LoginPages {

    @FindBy(xpath = ".//div[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(xpath = ".//li[@id='dashboard']//ul[@class='treeview-menu menu-open']//li[@id='prov_cus']")
    private WebElement submenuProviders;

    @FindBy(xpath = "//li[@id='dashboard']//a")
    private WebElement OpenedDashboard;

    @FindBy(xpath = "//body[@class='skin-blue']/div[@class='wrapper']/aside[@class='main-sidebar sidebar-offcanvas']/section[@class='sidebar']/ul[@class='sidebar-menu']/li[@id='dictionary']/a[1]")
    private WebElement OpenedDictionaries;

    @FindBy(xpath = "section[@class='content']")
    private WebElement isElementDisplayPage;

    @FindBy(xpath = "//li[@id='apparat']")
    private WebElement OpenedApparatPage;

    @FindBy(xpath = "//li[@id='workers']")
    private WebElement OpenedWorkersPage;

    @FindBy(xpath = "//li[@id='spareType']")
    private WebElement OpenedSpareType;

    @FindBy(xpath = "//li[@id='spares']//a")
    private WebElement OpenedSparePage;

    @FindBy(xpath = "//li[@id='prov_cus']//a")
    private WebElement OpenedProvCus;

    @FindBy(xpath = "//li[@id='deal_type']//a")
    private WebElement OpenedDealType;

    @FindBy(xpath = "//li[@id='deal']")
    private WebElement dealPageMenuItem;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed() {
        return actionWithWebElement.isElementDisplay(avatar);
    }

    public void checkAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnSubmenuProviders() {
        actionWithWebElement.clickButton(submenuProviders);
    }

    public void openDealPage(){
        actionWithWebElement.clickButton(dealPageMenuItem);
    }

}
