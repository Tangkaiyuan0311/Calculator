package kaiyuan.assignment.operations.Impl;

import kaiyuan.assignment.operations.OperationFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component("multiplyOperation")
public class MultiplyOperation implements OperationFormat {
    @Override
    public Number apply(Number num1, Number num2) {
        BigDecimal x = new BigDecimal(num1.toString());
        BigDecimal y = new BigDecimal(num2.toString());
        return x.multiply(y);
    }
}