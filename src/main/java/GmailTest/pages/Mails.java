package GmailTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static GmailTest.core.CustomConditions.minimumSizeOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class Mails {
    static WebDriver driver;
    static GmailPage page;
    static WebDriverWait wait;

    //public static ElementsCollection emails = $$("[role='main'] .zA");

    public static void send(String email, String subject) {
        driver.findElement(By.partialLinkText("COMPOSE")).click();
        //$(byText("COMPOSE")).click();
        driver.findElement(By.name("to")).sendKeys(email);
        //$(By.name("to")).setValue(email);
        driver.findElement(By.name("subjectbox")).sendKeys(subject);
        //$(By.name("subjectbox")).setValue(subject);
        driver.findElement(By.partialLinkText("Send")).click();
        //$(byText("Send")).click();
    }

    //public static void assertMails(String... subjects) {
    //    wait.until(textToBePresentInElementLocated(By.cssSelector("([role='main'] .zA)" + ":nth-child(1)"), subjects));
        //emails.shouldHave(texts(subjects));
    //}

    public static void assertMail(int index, String subject) {
        wait.until(minimumSizeOf(By.cssSelector("([role='main'] .zA)"), index+1));
        wait.until((textToBePresentInElementLocated(By.cssSelector("([role='main'] .zA)" + ":nth-child(1)"), subject)));
        // wait.until(minimumSizeOf);
        //emails.get(index).shouldHave(text(subject));
    }

    public Mails(WebDriver driver){
        this.driver=driver;
    }

}
