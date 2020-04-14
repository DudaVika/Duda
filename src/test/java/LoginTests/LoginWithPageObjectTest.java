package LoginTests;

import org.junit.Test;
import parentTests.AbstractParentTests;

public class LoginWithPageObjectTest extends AbstractParentTests {

    @Test
    public void validLogin() {
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is not Present", homePage.isAvatarDisplayed());
    }
}
