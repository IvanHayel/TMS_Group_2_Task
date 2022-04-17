package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operation extends Entity {
    private static int lastGeneratedId = 0;

    private String operand;
    private double firstValue;
    private double secondValue;
    private double result;

    public Operation(String operand, double firstValue, double secondValue, double result) {
        id = generateNextId();
        this.operand = operand;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.result = result;
    }

    public Operation() {
        this(null, DOUBLE_DEFAULT_VALUE, DOUBLE_DEFAULT_VALUE, DOUBLE_DEFAULT_VALUE);
    }

    private static int generateNextId() {
        return ++lastGeneratedId;
    }
}