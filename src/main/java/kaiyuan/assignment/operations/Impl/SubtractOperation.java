package kaiyuan.assignment.operations.Impl;

import kaiyuan.assignment.operations.OperationFormat;
import org.springframework.stereotype.Component;

@Component("subtractOperation")
public class SubtractOperation implements OperationFormat {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
