package kaiyuan.assignment.Impl.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kaiyuan.assignment.Impl.BasicCalculator;
import kaiyuan.assignment.model.Operation;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the {@link BasicCalculator} class.
 * <p>
 * This class tests the basic arithmetic operations defined in the {@link Operation} enum,
 * as well as custom operations that can be added at runtime. It ensures that the calculator
 * behaves correctly for valid operations and throws appropriate exceptions for unsupported or
 * invalid operations.
 * </p>
 */
class BasicCalculatorTest {

    /**
     * The calculator instance used for testing.
     */
    private BasicCalculator calculator;

    /**
     * Sets up a new {@link BasicCalculator} instance before each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new BasicCalculator();
    }

    /**
     * Tests the addition operation.
     * <p>
     * Ensures that {@code 2 + 3} equals {@code 5.0}.
     * </p>
     */
    @Test
    void testAddition() {
        Assertions.assertEquals(5.0, calculator.basicCalculate(Operation.ADD, 2, 3));
    }

    /**
     * Tests the subtraction operation.
     * <p>
     * Ensures that {@code 3 - 2} equals {@code 1.0}.
     * </p>
     */
    @Test
    void testSubtraction() {
        Assertions.assertEquals(1.0, calculator.basicCalculate(Operation.SUBTRACT, 3, 2));
    }

    /**
     * Tests the multiplication operation.
     * <p>
     * Ensures that {@code 2 * 3} equals {@code 6.0}.
     * </p>
     */
    @Test
    void testMultiplication() {
        Assertions.assertEquals(6.0, calculator.basicCalculate(Operation.MULTIPLY, 2, 3));
    }

    /**
     * Tests the division operation.
     * <p>
     * Ensures that {@code 6 / 3} equals {@code 2.0}.
     * </p>
     */
    @Test
    void testDivision() {
        Assertions.assertEquals(2.0, calculator.basicCalculate(Operation.DIVIDE, 6, 3));
    }

    /**
     * Tests the division operation for division by zero.
     * <p>
     * Ensures that dividing by zero throws an {@link ArithmeticException}.
     * </p>
     */
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.basicCalculate(Operation.DIVIDE, 6, 0));
    }

    /**
     * Tests chaining multiple operations together.
     * <p>
     * Starts with an initial value of {@code 5}, adds {@code 3}, and then multiplies by {@code 5}.
     * Ensures that the result is {@code 40.0}.
     * </p>
     */
    @Test
    void testChainingOperations() {
        Number result = calculator.chainOperations(5, List.of(Operation.ADD, Operation.MULTIPLY), List.of(3, 5));
        Assertions.assertEquals(40.0, result);
    }

    /**
     * Tests adding a custom operation to the calculator.
     * <p>
     * Adds a custom operation that doubles the second operand and adds it to the first operand.
     * Ensures that applying the operation to {@code 1} and {@code 2} yields {@code 5.0}.
     * </p>
     */
    @Test
    void testAddedOperations() {
        calculator.addOperation("custom", (op1, op2) -> op1.doubleValue() + 2 * op2.doubleValue());
        Number result = calculator.calculate("custom", 1, 2);
        Assertions.assertEquals(5.0, result);
    }

    /**
     * Tests that an unsupported operation throws an {@link UnsupportedOperationException}.
     * <p>
     * Attempts to perform a "MOD" operation, which is not supported. Ensures that an exception
     * is thrown.
     * </p>
     */
    @Test
    void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate("MOD", 5, 2));
    }
}
