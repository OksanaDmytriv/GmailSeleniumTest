package GmailTest.pages;

import GmailTest.GmailPage.GmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Gmail{
    static WebDriver driver;
    static GmailPage page;

    public static void open() {
        driver.get("http://GmailTest.com");
    }

    public static void login(String email, String password) {
        driver.findElement(By.cssSelector("#Email")).sendKeys(email+ Keys.ENTER);
        page.passwordField.sendKeys(password+ Keys.ENTER);
    }
}
