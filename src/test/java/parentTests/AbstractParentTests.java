package parentTests;

import com.google.gson.annotations.Until;
import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DealPage;
import pages.HomePage;
import pages.LoginPages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AbstractParentTests {
    WebDriver webDriver;
    protected LoginPages loginPage;
    protected HomePage homePage;
    protected DealPage dealPage;
    protected Utils utils;
    private String pathToScreenShot;

    Properties props = new Properties();


    @Rule
    public TestName testName = new TestName();



    @Before
    public void setUp() throws Exception {

        pathToScreenShot    = "..\\duda\\target\\screenshot" + this.getClass().getPackage().getName() + this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPages(webDriver);
        homePage = new HomePage(webDriver);
        dealPage = new DealPage(webDriver);
        utils = new Utils();
        
    }

    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    public void Login() {
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is not Present", homePage.isAvatarDisplayed());
    }

    public void checkExpectedResult(String message, boolean actualResult) {
        if(!actualResult ==true){
            utils.screenShot(pathToScreenShot, webDriver);
        }
        Assert.assertEquals(message, true, actualResult);
    }

    public void checkIsFalse(String message, boolean actualResult){
        Assert.assertFalse(message, actualResult);
    }
}
