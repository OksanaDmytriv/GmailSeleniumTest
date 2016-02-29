package GmailTest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Helpers {

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String URL) {
        driver.get(URL);
    }

}
