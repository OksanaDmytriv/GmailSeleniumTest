package v2402;

import GmailTest.pages.GmailPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static GmailPage page;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 6);
        page = new GmailPage(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
