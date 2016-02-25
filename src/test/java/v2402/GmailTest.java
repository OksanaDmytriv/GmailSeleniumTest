package v2402;

import GmailTest.pages.Gmail;
import GmailTest.pages.Mails;
import GmailTest.pages.Menu;
import org.junit.Test;



public class GmailTest extends BaseTest {

    @Test
    public void testGmailCommonFlow() {

        String subject = Helpers.getUniqueText("test");


        Gmail.open();
        Gmail.login(TestData.email, TestData.password);

        Mails.send(TestData.email, subject);
        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.openSent();
        Mails.assertMail(0, subject);

        Menu.openInbox();
        Menu.search(subject);
        //Mails.assertMails(subject);
    }

}

