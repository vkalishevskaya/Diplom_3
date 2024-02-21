import io.qameta.allure.Step;
import io.restassured.response.Response;
import main.java.api.Assertions;
import main.java.api.UserClient;
import main.java.api.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();
    private final Assertions check = new Assertions();
    private String accessToken;
    private String email;
    private String password;

    WebDriver driver;

    @Before
    @Step ("Create new user")
    public void userCreate() {
        driver = new ChromeDriver();

        var user = generator.random();
        Response creationResponse = (Response) client.createUser(user);
        check.userCreatedSuccessfully(creationResponse);
        this.accessToken = creationResponse.path("accessToken");
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void userLoginAccountButton(){
        MainPage mainPage = new MainPage(driver)
                .open()
                .waitForMainPageHeader();
        LoginPage loginPage = mainPage.clickAccountButtonLogin()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton()
                .waitForMainPageHeader();
    }
    @Test
    public void userLoginButton(){
        MainPage mainPage = new MainPage(driver)
                .open()
                .waitForMainPageHeader();
        LoginPage loginPage = mainPage.clickLoginButton()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton()
                .waitForMainPageHeader();
    }
    @Test
    public void loginFromRegistrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open()
                .scrollToLoginButton();
        LoginPage loginPage = registrationPage.clickLoginButton()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton();
    }
    @Test
    public void loginFromPasswordPage(){
        PasswordRenewalPage passwordPage = new PasswordRenewalPage(driver)
                .open();
        LoginPage loginPage = passwordPage.clickSignInButton()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton()
                .waitForMainPageHeader();
    }

    @After
    @Step("Delete test user")
    public void deleteUser() {
        if (accessToken!=null) {
            Response response = (Response) client.deleteUser(accessToken);
            check.deletedSuccessfully(response);
        }
    }

}



