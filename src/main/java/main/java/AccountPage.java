package main.java;

import io.qameta.allure.Step;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AccountPage {
    private WebDriver driver;
    public static final By accountMenu = By.xpath(".//div/nav/ul");
    public static final By logOutButton = By.className("Account_button__14Yp3");
    public static final By constructorButton = By.xpath(".//li[1]/a/p");
    public static final By logoButton = By.xpath(".//nav/div");
    public AccountPage(WebDriver driver) {
        this.driver = driver;}

    @Step("Go to account page")
    public AccountPage open() {
        driver.get(EnvConfig.ACCOUNT_URL);
        return this;
    }
    @Step("Wait for account menu to load")
    public AccountPage waitForAccountMenu(){
        ActionHelper.waitDisplayedElement(driver, accountMenu);
        return this;}

    @Step("Log out from account")
    public LoginPage clickLogOutButton(){
        driver.findElement(logOutButton).click();
        return new LoginPage(driver);
    }
    @Step("Go to constructor page through button")
    public MainPage clickConstructorButton(){
        driver.findElement(constructorButton).click();
        return new MainPage(driver);
    }
    @Step("Go to constructor page through logo")
    public MainPage clickLogoButton(){
        driver.findElement(logoButton).click();
        return new MainPage(driver);
    }
}
