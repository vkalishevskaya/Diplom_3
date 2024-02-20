package test.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.java.api.Assertions;
import main.java.api.UserClient;
import main.java.api.UserGenerator;
import main.java.*;
import org.junit.*;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AccountPageTest {

    private final UserGenerator generator = new UserGenerator();
    private final UserClient client = new UserClient();
    private final Assertions check = new Assertions();
    //MainPage mainPage;
    private String accessToken;
    private String email;
    private String password;

    WebDriver driver;


    @Before


    public void userLogin() {


        var user = generator.random();
        Response creationResponse = client.createUser(user);
        check.userCreatedSuccessfully(creationResponse);
        this.accessToken = creationResponse.path("accessToken");
        this.email = user.getEmail();
        this.password = user.getPassword();


        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver)
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

    @After
    public void teardown() {
            driver.quit();
    }

    @Test
    public void accountOpening(){
       MainPage mainPage = new MainPage(driver)
                .open()
                .waitForMainPageHeader();
        AccountPage accountPage = mainPage.clickAccountButton()
                .waitForAccountMenu();
    }

}
