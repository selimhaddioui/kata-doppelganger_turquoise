package mock;

import info.dmerej.HttpClient;
import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;

public class MockHttpClient implements HttpClient {
    private SendMailRequest sendMailRequest;

    @Override
    public SendMailResponse post(String url, Object request) {
        if (!(request instanceof SendMailRequest)) {
            sendMailRequest = null;
            return null;
        }
        sendMailRequest = (SendMailRequest) request;
        if(sendMailRequest.recipient().equals("retry")){
            return new SendMailResponse(503, "");
        }
        return null;
    }

    public SendMailRequest getSendMailRequest() {
        return sendMailRequest;
    }
}
