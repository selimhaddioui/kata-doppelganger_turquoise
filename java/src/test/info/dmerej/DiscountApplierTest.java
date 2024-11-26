package info.dmerej;

import mock.MockNotifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DiscountApplierTest {
  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    // Arrange
    List<info.dmerej.User> users = new ArrayList<>();
    List<info.dmerej.User> notifiedUsers = new ArrayList<>();
    info.dmerej.DiscountApplier discountApplier = new info.dmerej.DiscountApplier(new MockNotifier(notifiedUsers));
    users.add(new info.dmerej.User("lydia", "lydia.terki"));
    users.add(new info.dmerej.User("mathieu", "mathieu.willem"));
    users.add(new info.dmerej.User("mohamed", "mohamed.zammit-chatti"));
    users.add(new info.dmerej.User("selim", "selim.haddioui"));
    int discount = 50;

    // Act
    discountApplier.applyV1(discount, users);

    // Assert
    Assertions.assertEquals(users, notifiedUsers);
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    // Arrange
    List<info.dmerej.User> users = new ArrayList<>();
    List<info.dmerej.User> notifiedUsers = new ArrayList<>();
    info.dmerej.DiscountApplier discountApplier = new info.dmerej.DiscountApplier(new MockNotifier(notifiedUsers));
    users.add(new info.dmerej.User("lydia", "lydia.terki"));
    users.add(new info.dmerej.User("mathieu", "mathieu.willem"));
    users.add(new info.dmerej.User("mohamed", "mohamed.zammit-chatti"));
    users.add(new info.dmerej.User("selim", "selim.haddioui"));
    int discount = 50;

    // Act
    discountApplier.applyV2(discount, users);

    // Assert
    Assertions.assertEquals(users, notifiedUsers);
  }

}
