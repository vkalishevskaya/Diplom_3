package test.java;

import main.java.DriverRule;
import main.java.MainPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ConstructorTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    @Before
    public void mainPageOpen(){
        MainPage mainPage = new MainPage(driverRule.getDriver())
                .open();
    }

    @Test
    public void bunConstructorChapter(){
        MainPage mainPage = new MainPage(driverRule.getDriver())
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader()
                .clickBunsButton()
                .waitForBunHeader();
    }
    @Test
    public void saucesConstructorChapter(){
        MainPage mainPage = new MainPage(driverRule.getDriver())
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader()
                .clickSaucesButton()
                .waitForSaucesHeader();
    }
    @Test
    public void fillingConstructorChapter(){
        MainPage mainPage = new MainPage(driverRule.getDriver())
                .waitForMainPageHeader()
                .clickFillingButton()
                .waitForFillingHeader();
    }
}
