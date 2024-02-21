import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRenewalPage {
    private WebDriver driver;
    public static final By renewalPasswordPageHeader = By.xpath(".//main/div/h2");
    private static final By loginButton = By.className("Auth_link__1fOlj");
    public PasswordRenewalPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Open password renewal page")
    public PasswordRenewalPage open() {
        driver.get(EnvConfig.PASSWORD_PAGE);
        return this;
    }
    @Step("Wait for registration page header to load")
    public PasswordRenewalPage waitForRegisterPageHeader() {
        ActionHelper.waitDisplayedElement(driver, renewalPasswordPageHeader);
        return this;
    }
    @Step("Click sign in button on registration page")
    public LoginPage clickSignInButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
