package kaiyuan.assignment.model;


// Calculator interface that can be implemented by different classes,
// ensuring the solution is compatible with Inversion of Control (IoC) environments.



/**
 * The {@code Calculator} interface defines the basic contract for performing arithmetic operations.
 * Implementations of this interface should provide functionality to perform operations defined in
 * the {@link Operation} enum.
 */
public interface Calculator {

    /**
     * Performs a basic calculation using the specified {@link Operation}.
     *
     * @param operation the operation to perform, represented by an {@link Operation} enum constant
     * @param num1      the first operand, represented as a {@link Number}
     * @param num2      the second operand, represented as a {@link Number}
     * @return the result of applying the operation to the given operands, as a {@link Number}
     * @throws UnsupportedOperationException if the operation is not supported by the implementation
     */
    Number basicCalculate(Operation operation, Number num1, Number num2);
}
