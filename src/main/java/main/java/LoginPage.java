package main.java;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public static final By loginPageHeader = By.xpath(".//main/div/h2"); // хэдер страницы Вход
    private static final By emailField = By.xpath(".//fieldset[1]/div/div/input"); // поле ввода почты
    private static final By passwordField = By.xpath(".//fieldset[2]/div/div/input");
    private static final By loginButton = By.className("button_button__33qZ0");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(EnvConfig.LOGIN_URL);
        return this;
    }
    @Step("Wait for login page header to load")
    public LoginPage waitForLoginPageHeader() {
        ActionHelper.waitDisplayedElement(driver, loginPageHeader);
        return this;
    }
    @Step("Type Email on login page")
    public LoginPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Type password on login page")
    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step("Click sign in button on registration page")
    public MainPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }
}
