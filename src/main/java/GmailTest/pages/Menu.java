package GmailTest.pages;

import GmailTest.GmailPage.GmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Menu{

    static WebDriver driver;
    static GmailPage page;

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
        page.search.clear();
        page.search.sendKeys("subject:" + subject + Keys.ENTER);
        //driver.findElement(By.name("q")).clear();
        //driver.findElement(By.name("q")).sendKeys(subject+ Keys.ENTER);
    }
}
