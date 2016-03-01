import core.Configuration;
import org.junit.Test;
import pages.GmailPage;
import pages.MailsPage;
import pages.MenuPage;

import static core.Helpers.getUniqueText;

public class GmailTest extends BaseTest {

    static {
        Configuration.timeout = 15000;
    }

    GmailPage gmail = new GmailPage(driver);
    MailsPage mails = new MailsPage(driver);
    MenuPage menu = new MenuPage(driver);

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        gmail.visit();
        gmail.login(TestData.email, TestData.password);

        mails.send(TestData.email, subject);
        menu.refresh();
        mails.assertMail(1, subject);

        menu.openSent();
        mails.assertMail(1, subject);

        menu.openInbox();
        menu.search(subject);
        mails.assertMails(subject);
    }

}

