package kaiyuan.assignment.model;

import java.util.*;

/**
 * Enum {@code Operation} defines basic arithmetic operations: ADD, SUBTRACT, MULTIPLY, and DIVIDE.
 * Each operation can be applied to two {@link Number} operands, returning a {@link Number} result.
 *
 * <p>This enum supports the basic operations by overriding the {@link #apply(Number, Number)} method
 * for each constant. The operations are performed with double precision.
 *
 * <p>The enum also provides a method to check whether a given operation is supported.
 *
 * <pre>{@code
 * Number result = Operation.ADD.apply(5, 3); // result is 8.0
 * boolean isSupported = Operation.isSupported("ADD"); // true
 * }</pre>
 * </p>
 */
public enum Operation {

    /**
     * Addition operation, adds two numbers.
     */
    ADD {
        @Override
        public Number apply(Number x, Number y) {
            return x.doubleValue() + y.doubleValue();
        }
    },

    /**
     * Subtraction operation, subtracts the second number from the first.
     */
    SUBTRACT {
        @Override
        public Number apply(Number x, Number y) {
            return x.doubleValue() - y.doubleValue();
        }
    },

    /**
     * Multiplication operation, multiplies two numbers.
     */
    MULTIPLY {
        @Override
        public Number apply(Number x, Number y) {
            return x.doubleValue() * y.doubleValue();
        }
    },

    /**
     * Division operation, divides the first number by the second.
     * <p>If the second number is zero, an {@link ArithmeticException} is thrown.</p>
     */
    DIVIDE {
        @Override
        public Number apply(Number x, Number y) {
            if (y.doubleValue() == 0) throw new ArithmeticException("Division by zero");
            return x.doubleValue() / y.doubleValue();
        }
    };

    /**
     * A set of basic operations supported by this enum: ADD, SUBTRACT, MULTIPLY, and DIVIDE.
     * This set is unmodifiable.
     */
    private static final Set<String> supportedBasicOperations =
            Collections.unmodifiableSet(Set.of("ADD", "SUBTRACT", "MULTIPLY", "DIVIDE"));

    /**
     * Applies the operation to the given operands {@code x} and {@code y}.
     *
     * @param x the first operand
     * @param y the second operand
     * @return the result of applying the operation to {@code x} and {@code y}
     */
    public abstract Number apply(Number x, Number y);

    /**
     * Checks if the given operation is supported.
     *
     * @param operation the name of the operation to check (e.g., "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE")
     * @return {@code true} if the operation is supported, {@code false} otherwise
     */
    public static boolean isSupported(String operation) {
        return supportedBasicOperations.contains(operation);
    }
}