package pages;

import libs.ConfigClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import org.junit.Assert;


public class LoginPages extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLoginName;

    @FindBy(name = "_password")
    private WebElement inputPasswordName;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement inputButtonXpath;

    @FindBy(xpath = ".//div[@class='login-box-body']")
    private WebElement loginBox;

    public LoginPages(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPageLogin() {
        try{
            webDriver.get(ConfigClass.getCfgValue("base_url")+ "/login");
            logger.info("Page login was opened");
        }catch(Exception e) {
            logger.error("Can not open URL");
            Assert.fail("Can not open URL");
        }
    }

    public  void openPage(){
        try {
            webDriver.get(ConfigClass.getCfgValue("base_url"));
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void inputLogin(String text){
        actionWithWebElement.enterTextToField(inputLoginName, text);
    }

    public void inputPassword(String text){
        actionWithWebElement.enterTextToField(inputPasswordName , text);
    }

    public void clickSubmitButton(){
        actionWithWebElement.clickButton(inputButtonXpath);
    }

    public boolean isLoginBoxRefreshed(){
        return actionWithWebElement.isElementDisplay(loginBox);
    }

    public void LoginToPage(String login, String pass){
        inputLogin(login);
        inputPassword(pass);
        clickSubmitButton();
    }
}
