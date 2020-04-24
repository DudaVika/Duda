package suite;

import LoginTests.LoginWithPageObjectTest;
import LoginTests.LoginWithPageObjectUpperLogin;
import LoginTests.LoginWithPageObjectWrongTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjectTest.class,
                LoginWithPageObjectUpperLogin.class,
                LoginWithPageObjectWrongTest.class
        }
)

public class LoginSuit {


}
