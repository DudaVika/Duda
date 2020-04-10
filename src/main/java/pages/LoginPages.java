package pages;

import libs.ActionWithWebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPages {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithWebElement actionWithWebElement;
    By inputLoginName = By.name("_username");
    By inputPasswordName = By.name("_password");
    By inputButtonXpath = By.xpath(".//button[@type = 'submit']");
    String url = "\"http://v3.test.itpmgroup.com\"";

    public LoginPages(WebDriver webDriver){
        this.webDriver = webDriver;
        actionWithWebElement = new ActionWithWebElement(webDriver);
    }

    public  void openPage(){
        try {
            webDriver.get(url);

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
    public void clickButton(){
        actionWithWebElement.cklickButton(inputButtonXpath);
    }
    public void LoginToPage(String login, String pass){
        inputLogin(login);
        inputPassword(pass);
        clickButton();
    }
}
