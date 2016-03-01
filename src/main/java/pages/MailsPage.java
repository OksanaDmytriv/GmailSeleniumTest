package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static core.CustomConditions.emailContainText;

public class MailsPage extends BasePage {

    @FindBy(css = "([role='main'] .zA)")
    public
    List<WebElement> emails;

    @FindBy(xpath = "//div[text()[contains(.,'COMPOSE')]]")
    public
    WebElement composeButton;

    @FindBy(xpath = "//div[text()[contains(.,'Send')]]")
    public
    WebElement sendButton;

    @FindBy(name = "to")
    public
    WebElement recipient;

    public void send(String email, String subject) {
        assertThat(visibilityOf(composeButton));
        composeButton.click();
        assertThat(visibilityOf(recipient));
        recipient.sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subject);
        sendButton.click();
    }

    public void assertMails(String subjects) {
        assertThat(emailContainText(By.cssSelector("[role='main'] .zA:nth-child(1)"), subjects));
    }

    public void assertMail(int index, String subject) {
        assertThat(emailContainText(By.cssSelector("[role='main'] .zA:nth-child("+ index +")"), subject));
    }

    public MailsPage(WebDriver driver) {
        super(driver);
    }
}
