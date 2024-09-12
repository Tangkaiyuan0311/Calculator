package kaiyuan.assignment.operations;

import lombok.Getter;

import java.util.*;

/**
 * Enum representing basic mathematical operations.
 *
 * <p>This enum stores the Spring bean name for each operation strategy implementation.
 * It helps to decouple the operation name from the actual implementation, allowing
 * the Spring framework to manage the respective operation strategies through dependency injection.
 * </p>
 *
 * <p>Each enum constant (ADD, SUBTRACT, MULTIPLY, DIVIDE) is associated with a corresponding
 * Spring bean name that is used to resolve the correct operation strategy.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     Operation.ADD.getImplBean(); // returns "addStrategy"
 * </pre>
 *
 */
@Getter
public enum Operation {

    /**
     * Represents the addition operation.
     * Corresponds to the Spring bean "addOperation".
     */
    ADD("addOperation"),

    /**
     * Represents the subtraction operation.
     * Corresponds to the Spring bean "subtractStrategy".
     */
    SUBTRACT("subtractOperation"),

    /**
     * Represents the multiplication operation.
     * Corresponds to the Spring bean "multiplyOperation".
     */
    MULTIPLY("multiplyOperation"),

    /**
     * Represents the division operation.
     * Corresponds to the Spring bean "divideOperation".
     */
    DIVIDE("divideOperation");

    /**
     * The Spring bean name corresponding to the operation's implementation.
     */
    private final String ImplBean;

    /**
     * Private constructor to associate each operation with its corresponding Spring bean.
     *
     * @param ImplBean the Spring bean name for the operation's implementation
     */
    Operation(String ImplBean) {
        this.ImplBean = ImplBean;
    }
}