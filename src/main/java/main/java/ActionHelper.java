package main.java;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionHelper {
    public static void doScrolling(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    @Step ("Wait for header to display")
    public static void waitDisplayedElement(WebDriver driver, By locator, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitDisplayedElement(WebDriver driver, By locator) {
        ActionHelper.waitDisplayedElement(driver, locator, EnvConfig.DEFAULT_TIMEOUT);
    }
    public static void scrollTo(WebDriver driver, By locator, int timeoutSeconds) {
        ActionHelper.doScrolling(driver, driver.findElement(locator));
        ActionHelper.waitDisplayedElement(driver, locator, timeoutSeconds);
    }

    public static void scrollTo(WebDriver driver, By locator) {
        ActionHelper.scrollTo(driver, locator, EnvConfig.DEFAULT_TIMEOUT);
    }
}
