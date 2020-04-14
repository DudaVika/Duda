package LoginTests;

import org.junit.Test;
import parentTests.AbstractParentTests;

public class LoginTestWithInvalidPassword extends AbstractParentTests {

    @Test
    public void invalidPassword() {
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909");
        loginPage.clickSubmitButton();
        checkExpectedResult("Login box is not Present", loginPage.isLoginBoxRefreshed());
    }

    @Test
    public void invalidEmptyPassword() {
        loginPage.openPageLogin();
        loginPage.inputLogin("student");
        loginPage.inputPassword("");
        loginPage.clickSubmitButton();
        checkExpectedResult("Login box is not Present", loginPage.isLoginBoxRefreshed());
    }

    @Test
    public void invalidPasswordWithSpaces() {
        loginPage.openPageLogin();
        loginPage.inputLogin("student");
        loginPage.inputPassword("     ");
        loginPage.clickSubmitButton();
        checkExpectedResult("Login box is not Present", loginPage.isLoginBoxRefreshed());
    }
}
