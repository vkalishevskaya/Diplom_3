package test.java;
import io.restassured.response.Response;
import main.api.Assertions;
import main.api.UserClient;
import main.api.UserGenerator;
import main.java.WebDriverFactory;
import main.java.EnvConfig;
import main.java.RegistrationPage;
import main.java.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class RegistrationTest {
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    public WebDriver driver;

    @Test // Регистрация с валидным паролем
    public void registration() {
        RegistrationPage registrationPage = new RegistrationPage(webDriverFactory.getDriver())
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
        RegistrationPage registrationPage = new RegistrationPage(webDriverFactory.getDriver())
                .open()
                .waitForRegisterPageHeader()
                .typeName(EnvConfig.DEFAULT_NAME)
                .typeEmail(EnvConfig.DEFAULT_EMAIL)
                .typePassword(EnvConfig.INVALID_PASSWORD)
                .clickSignUpButtonInvalid()
                .waitForInvalidPasswordMessage();
    }

}
