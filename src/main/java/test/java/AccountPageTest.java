package test.java;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.api.Assertions;
import main.api.UserClient;
import main.api.UserGenerator;
import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;


public class AccountPageTest {

    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();
    private final Assertions check = new Assertions();
    private String accessToken;
    private String email;
    private String password;


    @Rule
    public WebDriverFactory webDriverFactory = new WebDriverFactory();
    public WebDriver driver;


    @Before
    @DisplayName("successful login")
    @Description("Creating new user and login with data")
    public void userLogin() {
        var user = generator.random();
        Response creationResponse = client.createUser(user);
        check.userCreatedSuccessfully(creationResponse);
        this.accessToken = creationResponse.path("accessToken");
        this.email = user.getEmail();
        this.password = user.getPassword();

        LoginPage loginPage = new LoginPage(webDriverFactory.getDriver())
                .open()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage main = loginPage.clickLoginButton()
                .waitForMainPageHeader();
    }


    @After
    public void deleteUser() {
        if (accessToken!=null) {
            Response response = client.deleteUser(accessToken);
            check.deletedSuccessfully(response);
        }
    }

    @Test
    public void accountOpening(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .open()
                .waitForMainPageHeader();
        AccountPage accountPage = mainPage.clickAccountButton()
                .waitForAccountMenu();
    }
}
