package GmailTest.pages;

import GmailTest.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MenuPage extends BasePage {

    @FindBy(name = "q")
    public
    WebElement search;

    @FindBy(xpath = "//a[text()[contains(.,'Inbox')]]")
    public
    WebElement inboxMenu;

    public void refresh() {
        $(By.cssSelector(".asf")).click();
    }

    public void openSent() {
        $(By.linkText("Sent Mail")).click();
    }

    public void openInbox() {
        inboxMenu.click();
    }

    public void search(String subject) {
        search.clear();
        search.sendKeys("subject:" + subject + Keys.ENTER);
    }

    public MenuPage(WebDriver driver) {
        super(driver);
    }
}
