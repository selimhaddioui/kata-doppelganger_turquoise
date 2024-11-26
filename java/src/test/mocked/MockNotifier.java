package mocked;

import info.dmerej.Notifier;
import info.dmerej.User;

import java.util.List;

public class MockNotifier implements Notifier {
    List<User> notifiedUsers;

    public MockNotifier(List<User> notifiedUsers) {
        this.notifiedUsers = notifiedUsers;
    }

    @Override
    public void notify(User user, String message) {
        notifiedUsers.add(user);
    }
}
