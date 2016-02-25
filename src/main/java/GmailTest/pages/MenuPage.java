package GmailTest.pages;

import GmailTest.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MenuPage extends BasePage{

    public static WebDriver driver;

    @FindBy(name = "q")
    public
    WebElement search;

    public void refresh() {
        driver.findElement(By.cssSelector(".asf")).click();
        //$(".asf").click();
    }

    public void openSent() {
        driver.findElement(By.cssSelector("Sent Mail")).click();
        //$(byTitle("Sent Mail")).click();
    }

    public void openInbox() {
        driver.findElement(By.cssSelector("Inbox")).click();
        //$(byTitle("Inbox")).click();
    }

    public void search(String subject) {
        search.clear();
        search.sendKeys("subject:" + subject + Keys.ENTER);
        //driver.findElement(By.name("q")).clear();
        //driver.findElement(By.name("q")).sendKeys(subject+ Keys.ENTER);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public MenuPage(WebDriver driver){
        super(driver);
    }
}
