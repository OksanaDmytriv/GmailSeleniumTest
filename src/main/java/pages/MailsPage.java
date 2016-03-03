package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.CustomConditions.listNthElementHasText;
import static core.CustomConditions.textsOf;

public class MailsPage extends BasePage {

    @FindBy(css = "[role='main'] .zA")
    public
    List<WebElement> emails;

    public void send(String email, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public void assertMails(String... subjects) {
        assertThat(textsOf(emails, subjects));
    }

    public void assertMail(int index, String subject) {
        assertThat(listNthElementHasText(emails, index, subject));
    }

    public MailsPage(WebDriver driver) {
        super(driver);
    }
}
