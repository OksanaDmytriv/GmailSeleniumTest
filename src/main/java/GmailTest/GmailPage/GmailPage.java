package GmailTest.GmailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailPage {
    static WebDriver driver;

    @FindBy(name = "q")
    public
    WebElement search;

    @FindBy(css = "([role='main'] .zA)")
    public
    List<WebElement> emails;

    @FindBy(id = "#Passwd")
    public
    WebElement passwordField;

    public GmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
