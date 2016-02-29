package v2402;

import GmailTest.core.Helpers;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends Helpers{

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
