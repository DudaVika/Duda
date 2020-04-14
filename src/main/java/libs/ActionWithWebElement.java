package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionWithWebElement {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithWebElement(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToField(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Warn");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error mess");
        }

    }

    public void clickButton(WebElement element) {
        try {
            element.click();
            logger.info("");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementDisplay(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public boolean isElementEnabled(WebElement element){
        try {
            return element.isEnabled();
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state){
        try {

            if (element.isSelected() == state) {

            }else {
                element.click();
            }
            logger.info("" + state);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("");

        }

    }

    public void selectElementFromDD(WebElement element, String itemName){
        Select dropDownValue = new Select(element);
        try {
            dropDownValue.selectByVisibleText(itemName);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }


}
