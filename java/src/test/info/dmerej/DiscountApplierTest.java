package info.dmerej;

import mocked.MockNotifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DiscountApplierTest {
  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    // Arrange
    ArrayList<User> users = new ArrayList<>();
    users.add(new User("lydia", "lydia.terki"));
    users.add(new User("mathieu", "mathieu.willem"));
    users.add(new User("mohamed", "mohamed.zammit-chatti"));
    users.add(new User("selim", "selim.haddioui"));
    ArrayList<User> notifiedUsers = new ArrayList<>();
    DiscountApplier discountApplier = new DiscountApplier(new MockNotifier(notifiedUsers));

    // Act
    discountApplier.applyV1(50, users);

    // Assert
    Assertions.assertEquals(users, notifiedUsers);
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    // Arrange
    List<User> users = new ArrayList<>();
    users.add(new User("lydia", "lydia.terki"));
    users.add(new User("mathieu", "mathieu.willem"));
    users.add(new User("mohamed", "mohamed.zammit-chatti"));
    users.add(new User("selim", "selim.haddioui"));
    List<User> notifiedUsers = new ArrayList<>();
    DiscountApplier discountApplier = new DiscountApplier(new MockNotifier(notifiedUsers));

    // Act
    discountApplier.applyV2(50, users);

    // Assert
    Assertions.assertEquals(users, notifiedUsers);
  }

  @Test
  void mockito_should_notify_twice_when_applying_discount_for_two_users_v1() {
    // Arrange
    List<User> users = new ArrayList<>();
    User lydia = new User("lydia", "lydia.terki");;
    User mathieu = new User("mathieu", "mathieu.willem");;
    User mohamed = new User("mohamed", "mohamed.zammit-chatti");;
    User selim = new User("selim", "selim.haddioui");;
    users.add(lydia);
    users.add(mathieu);
    users.add(mohamed);
    users.add(selim);
    Notifier mockedNotifier = mock(Notifier.class);
    DiscountApplier discountApplier = new DiscountApplier(mockedNotifier);

    // Act
    discountApplier.applyV1(50, users);

    // Assert
    verify(mockedNotifier).notify(lydia, "You've got a new discount of 50%");
    verify(mockedNotifier).notify(mathieu, "You've got a new discount of 50%");
    verify(mockedNotifier).notify(mohamed, "You've got a new discount of 50%");
    verify(mockedNotifier).notify(selim, "You've got a new discount of 50%");
  }

  @Test
  void mockito_should_notify_twice_when_applying_discount_for_two_users_v2() {
    // Arrange
    List<User> users = new ArrayList<>();
    User lydia = new User("lydia", "lydia.terki");;
    User mathieu = new User("mathieu", "mathieu.willem");;
    User mohamed = new User("mohamed", "mohamed.zammit-chatti");;
    User selim = new User("selim", "selim.haddioui");;
    users.add(lydia);
    users.add(mathieu);
    users.add(mohamed);
    users.add(selim);
    Notifier mockedNotifier = mock(Notifier.class);
    DiscountApplier discountApplier = new DiscountApplier(mockedNotifier);

    // Act
    discountApplier.applyV2(50, users);

    // Assert
    verify(mockedNotifier).notify(lydia, "You've got a new discount of 50%");
    verify(mockedNotifier).notify(mathieu, "You've got a new discount of 50%");
    verify(mockedNotifier).notify(mohamed, "You've got a new discount of 50%");
    verify(mockedNotifier).notify(selim, "You've got a new discount of 50%");
  }

}
