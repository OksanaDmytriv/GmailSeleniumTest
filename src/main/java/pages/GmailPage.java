package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GmailPage extends BasePage {

    public void login(String email, String password) {
        $(By.cssSelector("#Email")).sendKeys(email + Keys.ENTER);
        $(By.cssSelector("#Passwd")).sendKeys(password + Keys.ENTER);
    }

    public void visit(){
        open("http://gmail.com");
    }

    public GmailPage(WebDriver driver) {
        super(driver);
    }
}
