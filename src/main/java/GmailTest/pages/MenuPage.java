package GmailTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class MenuPage {

    static WebDriver driver;
    static GmailPage gmail;

    public static void refresh() {
        driver.findElement(By.cssSelector(".asf")).click();
        //$(".asf").click();
    }

    public static void openSent() {
        driver.findElement(By.cssSelector("Sent Mail")).click();
        //$(byTitle("Sent Mail")).click();
    }

    public static void openInbox() {
        driver.findElement(By.cssSelector("Inbox")).click();
        //$(byTitle("Inbox")).click();
    }

    public static void search(String subject) {
        gmail.search.clear();
        gmail.search.sendKeys("subject:" + subject + Keys.ENTER);
        //driver.findElement(By.name("q")).clear();
        //driver.findElement(By.name("q")).sendKeys(subject+ Keys.ENTER);
    }

    public MenuPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
