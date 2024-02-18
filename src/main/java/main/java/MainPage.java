package main.java;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public static final By accountButton = By.xpath(".//nav/a/p");
    public static final By loginButtonMainPage = By.className("button_button__33qZ0");
    public static final By constructorHeader = By.xpath(".//section[1]/h1");
    public static final By bunsButton = By.xpath(".//section[1]/div[1]/div[1]");
    public static final By saucesButton = By.xpath(".//div[1]/div[2]");
    public static final By fillingButton = By.xpath(".//div[1]/div[3]");
    public static final By constructorBunsHeader = By.xpath(".//section[1]/div[2]/h2[1]");
    public static final By constructorSaucesHeader = By.xpath(".//section[1]/div[2]/h2[2]");
    public static final By constructorFillingHeader = By.xpath(".//section[1]/div[2]/h2[3]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open main page")
    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }

    @Step("Click cabinet button on registration page")
    public AccountPage clickAccountButton() {
        driver.findElement(accountButton).click();
        return new AccountPage(driver);
    }
    @Step ("Open login page through account button")
    public LoginPage clickAccountButtonLogin() {
        driver.findElement(accountButton).click();
        return new LoginPage(driver);
    }
    @Step ("Open login page through account button")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButtonMainPage).click();
        return new LoginPage(driver);
    }
    @Step("Wait for main page header")
    public MainPage waitForMainPageHeader() {
        ActionHelper.waitDisplayedElement(driver, constructorHeader);
        return this;
    }
    @Step("Click cabinet button on registration page")
    public MainPage clickBunsButton() {
        driver.findElement(bunsButton).click();
        return this;
    }
    @Step("Click cabinet button on registration page")
    public MainPage clickSaucesButton() {
        driver.findElement(saucesButton).click();
        return this;
    }
    @Step("Click cabinet button on registration page")
    public MainPage clickFillingButton() {
        driver.findElement(fillingButton).click();
        return this;
    }
    @Step("Wait for main page header")
    public MainPage waitForBunHeader() {
        ActionHelper.waitDisplayedElement(driver, constructorBunsHeader);
        return this;
    }
    @Step("Wait for main page header")
    public MainPage waitForSaucesHeader() {
        ActionHelper.waitDisplayedElement(driver, constructorSaucesHeader);
        return this;
    }
    @Step("Wait for main page header")
    public MainPage waitForFillingHeader() {
        ActionHelper.waitDisplayedElement(driver, constructorFillingHeader);
        return this;
    }

}
