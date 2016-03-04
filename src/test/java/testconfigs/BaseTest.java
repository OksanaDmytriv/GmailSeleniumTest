package testconfigs;

import core.ConciseAPI;
import core.Configuration;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends ConciseAPI {

    public static WebDriver driver = new FirefoxDriver();

    static {
        Configuration.timeout = 20;
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
