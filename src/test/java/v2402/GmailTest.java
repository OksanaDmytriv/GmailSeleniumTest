package v2402;

import GmailTest.pages.Gmail;
import GmailTest.pages.Mails;
import GmailTest.pages.Menu;
import org.junit.Test;

public class GmailTest extends BaseTest {

    @Test
    public void testGmailCommonFlow() {

        Gmail gmail = new Gmail(driver);
        Menu menu = new Menu(driver);
        Mails mails = new Mails(driver);

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

