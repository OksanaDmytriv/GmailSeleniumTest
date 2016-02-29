package GmailTest.pages;

import GmailTest.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class GmailPage extends BasePage {

    @FindBy(id = "Passwd")
    public
    WebElement passwordField;

    public void login(String email, String password) {
        $(By.cssSelector("#Email")).sendKeys(email + Keys.ENTER);
        assertThat(visibilityOf(passwordField));
        $(By.cssSelector("#Passwd")).sendKeys(password + Keys.ENTER);
    }

    public GmailPage(WebDriver driver) {
        super(driver);
    }
}
