package kaiyuan.assignment.model;


// Calculator interface that can be implemented by different classes,
// ensuring the solution is compatible with Inversion of Control (IoC) environments.


import kaiyuan.assignment.operations.Operation;


/**
 * Defines the contract for a calculator that supports basic mathematical operations
 * and allows chaining of multiple operations.
 *
 * <p>The {@code Calculator} interface provides methods to perform individual operations
 * as well as to chain multiple operations on a cumulative result. It supports both single
 * operations (through {@link #basicCalculate(Operation, Number, Number)}) and chained operations
 * where the result of one operation is used as the input for the next (through {@link #chainOperations(Operation, Number)}).</p>
 *
 * <p>This interface is designed to be flexible, allowing different implementations to
 * support various types of numbers and operation strategies.</p>
 */
public interface Calculator {

    /**
     * Performs a basic calculation with the specified operation on two numeric values.
     *
     * <p>This method applies the given {@link Operation} (e.g., addition, subtraction, multiplication, or division)
     * to {@code num1} and {@code num2}, returning the result of the calculation.</p>
     *
     * @param operation the operation to be performed, such as ADD, SUBTRACT, MULTIPLY, or DIVIDE
     * @param num1 the first operand
     * @param num2 the second operand
     * @return the result of the operation
     */
    Number basicCalculate(Operation operation, Number num1, Number num2);

    /**
     * Chains the given operation with the current state of the calculator.
     *
     * <p>This method allows multiple operations to be performed sequentially by chaining them.
     * Each chained operation uses the result of the previous operation (or the initial state)
     * as the first operand, and {@code num} as the second operand.</p>
     *
     * @param operation the operation to be performed
     * @param num the second operand for the operation
     * @return the current {@code Calculator} instance, allowing for method chaining
     */
    Calculator chainOperations(Operation operation, Number num);

    /**
     * Returns the result of the chained operations.
     *
     * <p>This method returns the final result of all chained operations. If no operations
     * have been chained, it returns the initial state of the calculator.</p>
     *
     * @return the result of the chained operations, or the initial state if no operations were chained
     */
    Number getChainingResult();

    /**
     * Sets the initial state of the calculator.
     *
     * <p>This method initializes the calculator with a starting value. This initial value
     * will be used as the first operand in the first chained operation or as the result if no
     * operations are chained.</p>
     *
     * @param initialState the initial state of the calculator
     * @return the current {@code Calculator} instance, allowing for method chaining
     */
    Calculator setState(Number initialState);
}
