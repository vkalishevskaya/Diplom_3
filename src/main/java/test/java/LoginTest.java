package test.java;

import io.qameta.allure.Step;
import main.api.Assertions;
import main.api.UserClient;
import main.api.UserGenerator;
import main.java.*;
import org.junit.After;
import org.junit.Before;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();
    private final Assertions check = new Assertions();
    private String accessToken;
    private String email;
    private String password;


    WebDriverFactory webDriverFactory = new WebDriverFactory();
    public WebDriver driver;

    @Before
    @Step ("Create new user")
    public void userCreate() {
        var user = generator.random();
        Response creationResponse = (Response) client.createUser(user);
        check.userCreatedSuccessfully(creationResponse);
        this.accessToken = creationResponse.path("accessToken");
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    @Test
    public void userLoginAccountButton(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .open()
                .waitForMainPageHeader();
        LoginPage loginPage = mainPage.clickAccountButtonLogin()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton();
    }
    @Test
    public void userLoginButton(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .open()
                .waitForMainPageHeader();
        LoginPage loginPage = mainPage.clickLoginButton()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton();
    }
    @Test
    public void loginFromRegistrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(webDriverFactory.getDriver());
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
        PasswordRenewalPage passwordPage = new PasswordRenewalPage(webDriverFactory.getDriver())
                .open();
        LoginPage loginPage = passwordPage.clickSignInButton()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton();
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



