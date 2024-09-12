package kaiyuan.assignmnet.Impl;

import kaiyuan.assignment.Application;
import kaiyuan.assignment.Impl.BasicCalculator;
import kaiyuan.assignment.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kaiyuan.assignment.operations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Unit test class for {@link BasicCalculator}.
 *
 * <p>This class uses Spring Boot's {@link SpringBootTest} annotation to load the full application context and
 * inject the necessary dependencies to test the behavior of the {@link BasicCalculator} class.</p>
 *
 * <p>The tests cover the basic mathematical operations (addition, subtraction, multiplication, division),
 * as well as chaining operations and handling edge cases like division by zero.</p>
 *
 */
@SpringBootTest(classes = Application.class)
class BasicCalculatorTest {

    @Autowired
    private ApplicationContext context;

    /**
     * The {@link Calculator} instance used for testing, retrieved from the Spring application context.
     */
    private Calculator calculator;

    /**
     * Sets up the test environment before each test.
     * <p>
     * This method retrieves a new {@link Calculator} instance from the Spring context before each test,
     * ensuring a fresh calculator instance for each test case.
     * </p>
     */
    @BeforeEach
    void setUp() {
        calculator = context.getBean(Calculator.class);
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
        Assertions.assertEquals(6.0, calculator.basicCalculate(Operation.MULTIPLY, 2, 3).doubleValue());
    }

    /**
     * Tests the division operation.
     * <p>
     * Ensures that {@code 6 / 3} equals {@code 2.0}.
     * </p>
     */
    @Test
    void testDivision() {
        Assertions.assertEquals(2.0, calculator.basicCalculate(Operation.DIVIDE, 6, 3).doubleValue());
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
        Number result = calculator.setState(5)
                .chainOperations(Operation.ADD, 3)
                .chainOperations(Operation.MULTIPLY, 5)
                .getChainingResult();
        Assertions.assertEquals(40.0, result.doubleValue());
    }

    /**
     * Tests an unsupported operation, ensuring that calling chainOperations without
     * setting an initial state throws an {@link UnsupportedOperationException}.
     */
    @Test
    void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.chainOperations(Operation.ADD, 3));
    }
}
