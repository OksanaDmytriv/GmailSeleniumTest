package v2402;

import org.junit.Test;

public class GmailTest extends BaseTest {

    @Test
    public void testGmailCommonFlow() {

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

