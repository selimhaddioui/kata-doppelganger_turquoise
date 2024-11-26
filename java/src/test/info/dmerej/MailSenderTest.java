package info.dmerej;

import info.dmerej.mailprovider.SendMailRequest;
import mocked.MockHttpClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MailSenderTest {
    @Test
    void should_make_a_valid_http_request() {
        // Arrange
        MockHttpClient mockHttpClient = new MockHttpClient();
        MailSender mailSender = new MailSender(mockHttpClient);
        User user = new User("mohamed zammit chatti", "mohamed.zatti@efrei.net");
        String message = "Email body";

        // Act
        mailSender.sendV1(user, message);

        // Assert
        SendMailRequest sendMailRequest = mockHttpClient.getSendMailRequest();
        assertEquals(sendMailRequest.recipient(), "mohamed.zatti@efrei.net");
        assertEquals(sendMailRequest.subject(), "New notification");
        assertEquals(sendMailRequest.body(), "Email body");
    }

    @Test
    void should_retry_when_getting_a_503_error() {
        // Arrange
        MockHttpClient mockHttpClient = new MockHttpClient();
        MailSender mailSender = new MailSender(mockHttpClient);
        User user = new User("mohamed zammit chatti", "retry");
        String message = "Email body";

        // Act
        mailSender.sendV1(user, message);

        // Assert
        SendMailRequest sendMailRequest = mockHttpClient.getSendMailRequest();
        assertEquals(sendMailRequest.recipient(), "retry");
        assertEquals(sendMailRequest.subject(), "New notification");
        assertEquals(sendMailRequest.body(), "Email body");
    }

    @Test
    void mockito_should_make_a_valid_http_request() {
       // #Todo
    }

    @Test
    void mockito_should_retry_when_getting_a_503_error() {
        // #Todo
    }
}
