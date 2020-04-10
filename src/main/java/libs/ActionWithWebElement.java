package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActionWithWebElement {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithWebElement(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToField(By element, String text) {
        try {
            webDriver.findElement(element).clear();
            webDriver.findElement(element).sendKeys(text);
            logger.info("Warn");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error mess");
        }

    }

    public void cklickButton(By element) {
        try {
            webDriver.findElement(element).click();
            logger.info("");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementDisplay(By element) {
        try {
            return webDriver.findElement(element).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }
    public boolean isElementEnabled(By element){
        try {
            return webDriver.findElement(element).isEnabled();
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("");
            return false;
        }
    }

    public void SetCheckBox(By element, String state){
        try {
            //TODO check
            if(webDriver.findElement(element).isSelected()){
                //== state
            }else {
                webDriver.findElement(element).click();
            }
            logger.info(""+state);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("");

        }

    }

    private void selectElementFromDD(By element, String itemName){
        Select dropDownValue = new Select(webDriver.findElement(element));
        try {
            dropDownValue.selectByVisibleText(itemName);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }


}
