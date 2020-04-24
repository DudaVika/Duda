package LoginTests;


import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Test;
import parentTests.AbstractParentTests;


import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends AbstractParentTests {

    @Test
    public void validLogin() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getCfgValue("DATA_FILE"), "validLogOn");

        loginPage.openPage();
        loginPage.inputLogin(dataForValidLogin.get("login"));
        loginPage.inputPassword(dataForValidLogin.get("pass"));
        loginPage.clickSubmitButton();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }



}
