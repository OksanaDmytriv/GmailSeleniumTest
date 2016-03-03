package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class MenuPage extends BasePage {

    public void refresh() {
        $(byCSS(".asf")).click();
    }

    public void openSent() {
        $(By.linkText("Sent Mail")).click();
    }

    public void openInbox() {
        $(byCSS("a[aria-label^='Inbox']")).click();
    }

    public void search(String subject) {
        $(By.name("q")).clear();
        $(By.name("q")).sendKeys("subject:" + subject + Keys.ENTER);
    }

    public MenuPage(WebDriver driver) {
        super(driver);
    }
}
