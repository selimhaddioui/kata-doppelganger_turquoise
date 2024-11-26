package info.dmerej;

import mocked.MockAuthorizer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SafeCalculatorTest {
  @Test
  void should_not_throw_when_authorized() {
    // Arrange
    SafeCalculator safeCalculator = new SafeCalculator(new MockAuthorizer());

    // Act & Assert
    assertDoesNotThrow(() -> safeCalculator.add(2, 5));
  }

  @Test
  void mockito_should_not_throw_when_authorized() {
      // Arrange
      Authorizer mockAuthorizer = mock(Authorizer.class);
      when(mockAuthorizer.authorize()).thenReturn(true);
      SafeCalculator safeCalculator = new SafeCalculator(mockAuthorizer);

      // Act & Assert
      assertDoesNotThrow(() -> safeCalculator.add(2, 5));
  }
}
