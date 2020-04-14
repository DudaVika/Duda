package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class DealPage extends ParentPage {

    @FindBy(xpath = "//*[contains(text(),'Список сделок')]")
    private WebElement dealListTitle;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='box-tools']")
    private WebElement addButton;

    @FindBy(xpath = "//form[@name='deal']")
    private WebElement dealEditForm;

    @FindBy(xpath = "//select[@id='deal_dealType']")
    private WebElement dealType;

    @FindBy(xpath = "//select[@id='deal_customer']")
    private WebElement dealCustomer;

    @FindBy(xpath = "//select[@id='deal_provider']")
    private WebElement dealProvider;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_day']")
    private WebElement dealDealDateDateDay;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_month']")
    private WebElement dealDealDateDateMonth;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_year']")
    private WebElement dealDealDateDateYear;

    @FindBy(xpath = "//select[@id='deal_dealDate_time_hour']")
    private WebElement dealDealDateTimeHour;

    @FindBy(xpath = "//select[@id='deal_dealDate_time_minute']")
    private WebElement dealDealDateTimeMinute;

    @FindBy(xpath = "//button[@name='delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//h3[contains(text(),'404')]")
    private WebElement notFoundPage;

    public DealPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkDealPageOpen() {
        Assert.assertTrue("Deal list is not displayed",
                actionWithWebElement.isElementDisplay(dealListTitle));
    }

    public void clickAddButton(){
        actionWithWebElement.clickButton(addButton);
    }

    public void clickSaveButton() {
        actionWithWebElement.clickButton(saveButton);
    }

    public void checkDealEditForm() {
        Assert.assertTrue("Form is not displayed",
                actionWithWebElement.isElementDisplay(dealEditForm));
    }

    public void checkPageNotFound() {
        Assert.assertTrue("Page not fount is not displayed",
                actionWithWebElement.isElementDisplay(notFoundPage));
    }

    public void selectDealType(String dealTypeValue){
        actionWithWebElement.selectElementFromDD(dealType, dealTypeValue);
    }

    public void selectDealCustomer(String dealCustomerValue){
        actionWithWebElement.selectElementFromDD(dealCustomer, dealCustomerValue);
    }

    public void selectDealProvider(String dealProviderValue){
        actionWithWebElement.selectElementFromDD(dealProvider, dealProviderValue);
    }

    public void selectDealDate(Number day, String month, Number year,
                               Number hour, Number minute){
        actionWithWebElement.selectElementFromDD(dealDealDateDateDay, day.toString());
        actionWithWebElement.selectElementFromDD(dealDealDateDateMonth, month);
        actionWithWebElement.selectElementFromDD(dealDealDateDateYear, year.toString());
        actionWithWebElement.selectElementFromDD(dealDealDateTimeHour, hour.toString());
        actionWithWebElement.selectElementFromDD(dealDealDateTimeMinute, minute.toString());
    }

    public void clickSubmitButton() {
        actionWithWebElement.clickButton(submitButton);
    }

    public void  clickDeleteButton(){
        actionWithWebElement.clickButton(deleteButton);
    }

    public boolean getIsRowDisplayed(String dateTime, String dealType, String dealCustomer, String dealProvider){
        boolean result = false;
        try {
            WebElement rowElement = getRowWebElement(dateTime,
                    dealType,
                    dealCustomer,
                    dealProvider);
            result = rowElement.isDisplayed();
        } catch (Exception e) {
            logger.error("Row element not found");
        }
        return result;
    }

    public void clickOnDealRow(String dateTime, String dealType, String dealCustomer, String dealProvider){
        try {
            WebElement rowElement = getRowWebElement(dateTime,
                    dealType,
                    dealCustomer,
                    dealProvider);
            rowElement.click();
        } catch (Exception e) {
            logger.error("Row element not found");
        }
    }

    private WebElement getRowWebElement(String dateTime, String dealType, String dealCustomer, String dealProvider){
        By rowXpath = By.xpath("//tr[./td/text()='" + dateTime +
                "' and ./td/text()='"+ dealType +
                "' and ./td/text()='"+ dealCustomer +
                "' and ./td/text()='"+ dealProvider + "']");
        WebElement rowElement = webDriver.findElement(rowXpath);
        return  rowElement;
    }
}
