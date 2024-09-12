package kaiyuan.assignment.Impl;

import kaiyuan.assignment.model.Calculator;
import kaiyuan.assignment.operations.Operation;
import kaiyuan.assignment.operations.OperationFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;



/**
 * Basic implementation of the {@link Calculator} interface, using Spring's {@link ApplicationContext}
 * to dynamically inject the appropriate operation strategy for each calculation.
 *
 * <p>This class supports both single basic operations (addition, subtraction, multiplication, and division)
 * as well as chaining of operations, where the result of one operation is used as the input for the next.</p>
 *
 * <p>The {@code BasicCalculator} uses the {@link OperationFormat} beans, which are resolved dynamically
 * through the Spring {@link ApplicationContext}. The state for chaining operations is maintained internally
 * and can be initialized using the {@link #setState(Number)} method.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     BasicCalculator calculator = new BasicCalculator(context);
 *     calculator.setState(10)
 *               .chainOperations(Operation.ADD, 5)
 *               .chainOperations(Operation.MULTIPLY, 2);
 *     Number result = calculator.getChainingResult(); // Result: 30
 * </pre>
 */
@Service
public class BasicCalculator implements Calculator {

    private final ApplicationContext context;

    // Holds the state for chained operations
    private Number state = null;

    /**
     * Constructor for {@code BasicCalculator}.
     *
     * @param context the Spring {@link ApplicationContext} used to retrieve operation strategies
     */
    @Autowired
    public BasicCalculator(ApplicationContext context) {
        this.context = context;
    }

    /**
     * Performs a basic calculation by applying the given {@link Operation} to two numeric values.
     *
     * <p>The actual calculation logic is handled by the corresponding {@link OperationFormat}
     * bean, which is retrieved from the {@link ApplicationContext}.</p>
     *
     * @param operation the operation to be performed (ADD, SUBTRACT, MULTIPLY, or DIVIDE)
     * @param num1 the first operand
     * @param num2 the second operand
     * @return the result of the operation
     * @throws IllegalArgumentException if the operation is not supported
     */
    @Override
    public Number basicCalculate(Operation operation, Number num1, Number num2) {
        OperationFormat strategy = (OperationFormat) context.getBean(operation.getImplBean());
        return strategy.apply(num1, num2);
    }

    /**
     * Chains the given operation to the current state, applying the operation
     * with {@code num} as the second operand and updating the state.
     *
     * @param operation the operation to be performed
     * @param num the second operand for the operation
     * @return the current {@code BasicCalculator} instance for method chaining
     * @throws UnsupportedOperationException if no initial state has been set
     */
    @Override
    public Calculator chainOperations(Operation operation, Number num) {
        if (state == null) {
            throw new UnsupportedOperationException("Chaining operation has no initial state");
        }
        state = basicCalculate(operation, state, num);
        return this;
    }

    /**
     * Returns the result of the chained operations.
     *
     * @return the result of the chained operations
     * @throws UnsupportedOperationException if no initial state has been set
     */
    @Override
    public Number getChainingResult() {
        if (state == null) {
            throw new UnsupportedOperationException("Chaining operation has no initial state");
        }
        return state;
    }

    /**
     * Sets the initial state for chaining operations. This state will be used
     * as the first operand in the first chained operation.
     *
     * @param initialState the initial state of the calculator
     * @return the current {@code BasicCalculator} instance for method chaining
     * @throws UnsupportedOperationException if the state has already been initialized
     */
    @Override
    public Calculator setState(Number initialState) {
        if (state != null) {
            throw new UnsupportedOperationException("State is already initialized");
        }
        this.state = initialState;
        return this;
    }

}