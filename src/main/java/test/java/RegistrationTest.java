package test.java;
import main.java.DriverRule;
import main.java.EnvConfig;
import main.java.RegistrationPage;
import main.java.LoginPage;
import org.junit.Rule;
import org.junit.Test;


public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test // Регистрация с валидным паролем
    public void registration() {
        RegistrationPage registrationPage = new RegistrationPage(driverRule.getDriver())
                .open()
                .waitForRegisterPageHeader()
                .typeName(EnvConfig.DEFAULT_NAME)
                .typeEmail(EnvConfig.DEFAULT_EMAIL)
                .typePassword(EnvConfig.DEFAULT_PASSWORD);
        LoginPage loginPage = registrationPage.clickSignUpButton()
                .waitForLoginPageHeader();
    }
    @Test // Регистрация с валидным паролем
    public void registrationInvalid() {
        RegistrationPage registrationPage = new RegistrationPage(driverRule.getDriver())
                .open()
                .waitForRegisterPageHeader()
                .typeName(EnvConfig.DEFAULT_NAME)
                .typeEmail(EnvConfig.DEFAULT_EMAIL)
                .typePassword(EnvConfig.INVALID_PASSWORD)
                .clickSignUpButtonInvalid()
                .waitForInvalidPasswordMessage();
    }

}
