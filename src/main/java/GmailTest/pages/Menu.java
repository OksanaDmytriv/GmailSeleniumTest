package GmailTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


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

    public Menu(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
