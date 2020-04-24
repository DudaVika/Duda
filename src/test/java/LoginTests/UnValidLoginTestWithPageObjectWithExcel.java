package LoginTests;


import libs.ConfigClass;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTests.AbstractParentTests;
import parentTests.AbstractParentTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


@RunWith(Parameterized.class)
public class UnValidLoginTestWithPageObjectWithExcel extends AbstractParentTests {
    private String login, pass;

    public UnValidLoginTestWithPageObjectWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(ConfigClass.getCfgValue("DATA_FILE_PATH")
                    +"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void unvalidLogin() {
        loginPage.LoginToPage(login, pass);
        checkExpectedResult("Avatar should not be present" , !homePage.isAvatarDisplayed());
    }
}
