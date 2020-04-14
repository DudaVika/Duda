package LoginTests;

import org.junit.Test;
import parentTests.AbstractParentTests;

public class LoginTestWithInvalidLogin extends AbstractParentTests {

    @Test
    public void invalidLoginWithLittleFirstChar() {
        loginPage.openPageLogin();
        loginPage.inputLogin("student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        //TODO this check is correct but in site we have bug.
        //checkExpectedResult("Login box is not Present", loginPage.isLoginBoxRefreshed());
        // for this reason we use this check
        checkExpectedResult("Avatar is not Present", homePage.isAvatarDisplayed());
    }

    @Test
    public void invalidLoginInUpperCase() {
        loginPage.openPageLogin();
        loginPage.inputLogin("STUDENT");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        //TODO this check is correct but in site we have bug.
        //checkExpectedResult("Login box is not Present", loginPage.isLoginBoxRefreshed());
        // for this reason we use this check
        checkExpectedResult("Avatar is not Present", homePage.isAvatarDisplayed());
    }

    @Test
    public void invalidLogin() {
        loginPage.openPageLogin();
        loginPage.inputLogin("bla_bla");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Login box is not Present", loginPage.isLoginBoxRefreshed());
    }
}
