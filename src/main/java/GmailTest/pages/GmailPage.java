package GmailTest.pages;

import GmailTest.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GmailPage extends BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @FindBy(id = "#Passwd")
    public
    WebElement passwordField;

    public void open(String URL) {
        driver.get(URL);
    }

    public void login(String email, String password) {
        driver.findElement(By.cssSelector("#Email")).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOf(passwordField));
        //page.passwordField.sendKeys(password+ Keys.ENTER);
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(password + Keys.ENTER);
    }

    public GmailPage(WebDriver driver) {
super(driver);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
