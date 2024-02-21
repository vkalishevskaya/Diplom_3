import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistrationTest {
    WebDriver driver = new ChromeDriver();

    @Test // Регистрация с валидным паролем
    public void registration() {
        RegistrationPage registrationPage = new RegistrationPage(driver)
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
        RegistrationPage registrationPage = new RegistrationPage(driver)
                .open()
                .waitForRegisterPageHeader()
                .typeName(EnvConfig.DEFAULT_NAME)
                .typeEmail(EnvConfig.DEFAULT_EMAIL)
                .typePassword(EnvConfig.INVALID_PASSWORD)
                .clickSignUpButtonInvalid()
                .waitForInvalidPasswordMessage();
    }
    @After
    public void teardown() {
        driver.close();
    }

}
