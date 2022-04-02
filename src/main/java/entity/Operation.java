package entity;

public class Operation extends Entity {
    private String operand;
    private double firstValue;
    private double secondValue;
    private double result;

    public Operation() {
    }

    public Operation(String operand, double firstValue, double secondValue, double result) {
        this.operand = operand;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.result = result;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operand='" + operand + '\'' +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (Double.compare(operation.firstValue, firstValue) != 0) return false;
        if (Double.compare(operation.secondValue, secondValue) != 0) return false;
        if (Double.compare(operation.result, result) != 0) return false;
        return operand != null ? operand.equals(operation.operand) : operation.operand == null;
    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        result1 = operand != null ? operand.hashCode() : 0;
        temp = Double.doubleToLongBits(firstValue);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(secondValue);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(result);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        return result1;
    }
}