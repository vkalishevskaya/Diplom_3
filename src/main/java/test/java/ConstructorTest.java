package test.java;

import main.java.WebDriverFactory;
import main.java.MainPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTest {
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    public WebDriver driver;

    @Before
    public void mainPageOpen(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .open();
    }

    @Test
    public void bunConstructorChapter(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader()
                .clickBunsButton()
                .waitForBunHeader();
    }
    @Test
    public void saucesConstructorChapter(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader()
                .clickSaucesButton()
                .waitForSaucesHeader();
    }
    @Test
    public void fillingConstructorChapter(){
        MainPage mainPage = new MainPage(webDriverFactory.getDriver())
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader();
    }
}
