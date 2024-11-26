package mock;

import info.dmerej.Authorizer;

public class MockAuthorizer implements Authorizer {
    @Override
    public boolean authorize() {
        return true;
    }
}
