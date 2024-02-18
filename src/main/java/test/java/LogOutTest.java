package test.java;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import main.api.Assertions;
import main.api.UserClient;
import main.api.UserGenerator;
import main.java.AccountPage;
import main.java.DriverRule;
import main.java.LoginPage;
import main.java.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LogOutTest {
    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();
    private final Assertions check = new Assertions();
    private String accessToken;
    private String email;
    private String password;
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

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.open()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage mainPage = loginPage.clickLoginButton()
                .waitForMainPageHeader();

    }
    @Rule
    public DriverRule driverRule = new DriverRule();

    @After
    public void deleteUser() {
        if (accessToken!=null) {
            Response response = client.deleteUser(accessToken);
            check.deletedSuccessfully(response);
        }
    }
    @Test
    public void logOut(){
        AccountPage accountPage = new AccountPage(driverRule.getDriver())
                .open()
                .waitForAccountMenu();
        LoginPage loginPage = accountPage.clickLogOutButton()
                .waitForLoginPageHeader();
    }
}
