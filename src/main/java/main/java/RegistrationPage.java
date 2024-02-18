package main.java;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public static final By registerPageHeader = By.xpath(".//main/div/h2"); // хэдер страницы Регистрация
    private static final By nameField = By.xpath(".//fieldset[1]/div/div/input"); // поле ввода имени
    private static final By emailField = By.xpath(".//fieldset[2]/div/div/input"); // поле ввода почты
    private static final By passwordField = By.xpath(".//fieldset[3]/div/div/input"); // поле ввода пароля
    private static final By signUpButton = By.xpath(".//form/button"); //Кнопка Зарегистрироваться
    private static final By loginButton = By.className("Auth_link__1fOlj"); //Кнопка Войти
    private static final By invalidPasswordMessage = By.className("input__error");


    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }


    @Step("Open registration page")
    public RegistrationPage open() {
        driver.get(EnvConfig.REGISTER_URL);
        return this;
    }

    @Step("Wait for registration page header to load")
    public RegistrationPage waitForRegisterPageHeader() {
        ActionHelper.waitDisplayedElement(driver, registerPageHeader);
        return this;
    }
    @Step("Type name on registration page")
    public RegistrationPage typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    @Step("Type Email on registration page")
    public RegistrationPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Type password on registration page")
    public RegistrationPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step("Click sign up button on registration page")
    public LoginPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new LoginPage(driver);
    }
    @Step("Click sign in button on registration page")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    @Step("Click sign up button on registration page")
    public RegistrationPage clickSignUpButtonInvalid() {
        driver.findElement(signUpButton).click();
        return this;
    }

    @Step("Wait for invalid massage error to appear on registration page")
    public RegistrationPage waitForInvalidPasswordMessage() {
        ActionHelper.waitDisplayedElement(driver, invalidPasswordMessage);
        return this;
    }
    @Step("Scroll to login button")
    public void  scrollToLoginButton(){
        ActionHelper.scrollTo(driver, loginButton);
    }
}
