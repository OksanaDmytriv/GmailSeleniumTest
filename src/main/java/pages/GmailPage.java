package pages;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GmailPage extends BasePage {

    public void login(String email, String password) {
        $(byCSS("#Email")).sendKeys(email + Keys.ENTER);
        $(byCSS("#Passwd")).sendKeys(password + Keys.ENTER);
    }

    public void visit() {
        open("http://gmail.com");
    }

    public GmailPage(WebDriver driver) {
        super(driver);
    }
}
