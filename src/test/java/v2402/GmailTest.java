package v2402;

import GmailTest.pages.GmailPage;
import GmailTest.pages.MailsPage;
import GmailTest.pages.MenuPage;
import org.junit.Test;

public class GmailTest extends BaseTest {

    @Test
    public void testGmailCommonFlow() {

        GmailPage gmail = new GmailPage(driver);
        MenuPage menu = new MenuPage(driver);
        MailsPage mails = new MailsPage(driver);

        String subject = Helpers.getUniqueText("test");

        gmail.open("http://gmail.com");
        gmail.login(TestData.email, TestData.password);

        mails.send(TestData.email, subject);
        menu.refresh();
        mails.assertMail(0, subject);

        menu.openSent();
        mails.assertMail(0, subject);

        menu.openInbox();
        menu.search(subject);
        //mails.assertMails(subject);
    }

}

