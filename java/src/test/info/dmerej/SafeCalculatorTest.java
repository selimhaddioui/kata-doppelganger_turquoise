package info.dmerej;

import mock.MockAuthorizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SafeCalculatorTest {
  @Test
  void should_not_throw_when_authorized() {
    // Arrange
    info.dmerej.SafeCalculator safeCalculator = new info.dmerej.SafeCalculator(new MockAuthorizer());
    int left = 2;
    int right = 5;

    // Act & Assert
    assertDoesNotThrow(() -> safeCalculator.add(left, right));
  }
}
