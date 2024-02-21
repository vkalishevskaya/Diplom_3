import org.junit.After;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory extends ExternalResource {

    public WebDriver getDriver(){
        switch (System.getProperty("browser", "chrome")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("src/main/resources/chromedriver");
                return new ChromeDriver();
            case "chrome":
                default:
                return new ChromeDriver();
        }
    }

}