package test.java;

import main.java.WebDriverFactory;
import main.java.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConstructorTest {

    WebDriver driver;

    @Before
    public void mainPageOpen(){
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver)
                .open();
    }

    @Test
    public void bunConstructorChapter(){
        MainPage mainPage = new MainPage(driver)
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader()
                .clickBunsButton()
                .waitForBunHeader();
    }
    @Test
    public void saucesConstructorChapter(){
        MainPage mainPage = new MainPage(driver)
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader()
                .clickSaucesButton()
                .waitForSaucesHeader();
    }
    @Test
    public void fillingConstructorChapter(){
        MainPage mainPage = new MainPage(driver)
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader();
    }
}
