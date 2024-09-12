package kaiyuan.assignment.operations;


import java.math.BigDecimal;

/**
 * Represents the strategy for performing basic mathematical operations.
 *
 * <p>This interface defines the behavior for operations like addition, subtraction,
 * multiplication, and division. Each operation must implement the {@link #apply(Number, Number)}
 * method to perform its specific behavior.</p>
 *
 * <p>Implementations of this interface will encapsulate the specific logic for
 * their respective operations, enabling the use of different strategies through
 * dependency injection or other patterns (e.g., the strategy pattern).</p>
 *
 * <p>Example implementations include:</p>
 * <ul>
 *     <li>{@code AddOperation} for addition</li>
 *     <li>{@code SubtractOperation} for subtraction</li>
 *     <li>{@code MultiplyOperation} for multiplication</li>
 *     <li>{@code DivideOperation} for division</li>
 * </ul>
 *
 */
public interface OperationFormat {

    /**
     * Applies the specific operation on two numeric values.
     *
     * <p>This method should be implemented by each operation strategy (e.g., addition, subtraction, etc.)
     * to perform the specific operation. The inputs and the result are represented as {@link Number} objects,
     * allowing the strategy to handle different numeric types such as {@link Integer}, {@link Double}, or {@link BigDecimal}.</p>
     *
     * @param num1 the first operand
     * @param num2 the second operand
     * @return the result of applying the operation on {@code num1} and {@code num2}
     */
    Number apply(Number num1, Number num2);
}
