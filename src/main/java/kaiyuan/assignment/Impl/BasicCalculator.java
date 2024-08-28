package kaiyuan.assignment.Impl;

import kaiyuan.assignment.model.Calculator;
import kaiyuan.assignment.model.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;



/**
 * A basic implementation of the {@link Calculator} interface that supports basic arithmetic operations
 * and allows for dynamic operation addition. This class also provides a method for chaining multiple
 * operations together.
 * <p>
 * The {@code BasicCalculator} supports operations defined in the {@link Operation} enum as well as custom
 * operations added at runtime.
 * </p>
 */
public class BasicCalculator implements Calculator {

    /**
     * A map to store dynamically added operations. The keys are operation names (in uppercase),
     * and the values are {@link BiFunction} objects that define the operation logic.
     */
    private final Map<String, BiFunction<Number, Number, Number>> supportedDynamicOperations = new HashMap<>();

    /**
     * Constructs a new {@code BasicCalculator} instance with no initial dynamic operations.
     */
    public BasicCalculator() {
        // Default constructor
    }

    /**
     * Performs a basic calculation using the specified {@link Operation}.
     *
     * @param operation the operation to perform
     * @param num1      the first operand
     * @param num2      the second operand
     * @return the result of the operation
     * @throws UnsupportedOperationException if the operation is not supported
     */
    @Override
    public Number basicCalculate(Operation operation, Number num1, Number num2) {
        return operation.apply(num1, num2);
    }

    /**
     * Calculates the result of the specified operation, which can be a standard or a dynamically added operation.
     *
     * @param operationName the name of the operation to perform
     * @param num1          the first operand
     * @param num2          the second operand
     * @return the result of the operation
     * @throws UnsupportedOperationException if the operation is not supported
     */
    public Number calculate(String operationName, Number num1, Number num2) {
        String upperCaseOperationName = operationName.toUpperCase();
        if (supportedDynamicOperations.containsKey(upperCaseOperationName)) {
            return supportedDynamicOperations.get(upperCaseOperationName).apply(num1, num2);
        }
        if (Operation.isSupported(upperCaseOperationName)) {
            return basicCalculate(Operation.valueOf(upperCaseOperationName), num1, num2);
        }
        throw new UnsupportedOperationException("Operation not supported: " + operationName);
    }

    /**
     * Adds a new dynamic operation to the calculator.
     *
     * @param operationName the name of the operation (case-insensitive)
     * @param function      a {@link BiFunction} defining the operation logic
     * @throws IllegalArgumentException if the operation already exists
     */
    public void addOperation(String operationName, BiFunction<Number, Number, Number> function) {
        operationName = operationName.toUpperCase();
        if (supportedDynamicOperations.containsKey(operationName) || Operation.isSupported(operationName)) {
            throw new IllegalArgumentException("Operation " + operationName + " already exists");
        }
        supportedDynamicOperations.put(operationName, function);
    }

    /**
     * Performs a series of operations sequentially on an initial value.
     *
     * @param initialValue the starting value for the chain of operations
     * @param operations   the list of operations to perform, in order
     * @param operands     the list of operands corresponding to each operation
     * @return the result after applying all operations
     * @throws IllegalArgumentException if the sizes of operations and operands do not match
     */
    public Number chainOperations(Number initialValue, List<Operation> operations, List<Number> operands) {
        if (operations.size() != operands.size()) {
            throw new IllegalArgumentException("Operations and operands do not match");
        }

        Number result = initialValue;

        for (int i = 0; i < operations.size(); i++) {
            Operation operation = operations.get(i);
            Number nextValue = operands.get(i);
            result = basicCalculate(operation, result, nextValue);
        }
        return result;
    }
}