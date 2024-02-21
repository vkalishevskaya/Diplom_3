import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import main.java.api.Assertions;
import main.java.api.UserClient;
import main.java.api.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOutTest {
    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();
    private final Assertions check = new Assertions();
    private String accessToken;
    private String email;
    private String password;
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

        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .waitForLoginPageHeader()
                .typeEmail(email)
                .typePassword(password);
        MainPage mainPage = loginPage.clickLoginButton()
                .waitForMainPageHeader();

    }

    @After
    public void deleteUser() {
        if (accessToken!=null) {
            Response response = client.deleteUser(accessToken);
            check.deletedSuccessfully(response);
        }
    }
    @After
    public void teardown() {
        driver.close();
    }
    @Test
    public void logOut(){
        AccountPage accountPage = new AccountPage(driver)
                .open()
                .waitForAccountMenu();
        LoginPage loginPage = accountPage.clickLogOutButton()
                .waitForLoginPageHeader();
    }
}
