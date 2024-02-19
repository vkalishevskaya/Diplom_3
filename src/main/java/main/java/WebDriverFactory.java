package main.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {
    static WebDriver driver;

    @Before
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @After
    void teardown() {
        driver.quit();
    }

    public WebDriver getDriver(){
        switch (String.valueOf(System.getProperty("browser", "chrome"))) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                //ChromeOptions options = new ChromeOptions();
                //options.setBinary("src\\main\\resources\\chromedriver");

                return new ChromeDriver();
            case "chrome":
                default:
                return new ChromeDriver();
        }
    }
}