package kaiyuan.assignment.operations.Impl;

import kaiyuan.assignment.operations.OperationFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("divideOperation")
public class DivideOperation implements OperationFormat {
    @Override
    public Number apply(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        BigDecimal x = new BigDecimal(num1.toString());
        BigDecimal y = new BigDecimal(num2.toString());
        return x.divide(y, 5, RoundingMode.HALF_UP);
    }
}
