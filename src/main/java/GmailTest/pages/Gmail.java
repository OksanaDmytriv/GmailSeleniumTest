package GmailTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Gmail {
    static WebDriver driver;
    static GmailPage page;
    static WebDriverWait wait;

    public static void open(String URL) {
        driver.get(URL);
    }

    public static void login(String email, String password) {
        driver.findElement(By.cssSelector("#Email")).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOf(page.passwordField));
        //page.passwordField.sendKeys(password+ Keys.ENTER);
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(password + Keys.ENTER);
    }

    public Gmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
