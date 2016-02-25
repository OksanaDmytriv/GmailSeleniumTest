package GmailTest.pages;

import GmailTest.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static GmailTest.core.CustomConditions.minimumSizeOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MailsPage extends BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @FindBy(css = "([role='main'] .zA)")
    public
    List<WebElement> emails;

    //public static ElementsCollection emails = $$("[role='main'] .zA");

    public void send(String email, String subject) {
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

    public void assertMail(int index, String subject) {
        wait.until(minimumSizeOf(By.cssSelector("([role='main'] .zA)"), index + 1));
        wait.until((textToBePresentInElementLocated(By.cssSelector("([role='main'] .zA)" + ":nth-child(1)"), subject)));
        // wait.until(minimumSizeOf);
        //emails.get(index).shouldHave(text(subject));
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public MailsPage(WebDriver driver) {
        super(driver);
    }

}
