import core.ConciseAPI;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends ConciseAPI {

    static WebDriver driver = new FirefoxDriver();

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}