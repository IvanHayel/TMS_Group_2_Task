package entity;

public class Operation extends Entity {
    private String operand;
    private double firstValue;
    private double secondValue;
    private double result;

    public Operation(String operand, double firstValue, double secondValue) {
        this.operand = operand;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        calculate();
    }

    private void calculate() {
        switch (operand) {
            case "+":
            case "add":
            case "sum":
                result = firstValue + secondValue;
                break;
            case "-":
            case "sub":
            case "subtract":
                result = firstValue - secondValue;
                break;
            case "*":
            case "mult":
            case "multiply":
                result = firstValue * secondValue;
                break;
            case "/":
            case "div":
            case "divide":
                result = firstValue / secondValue;
                break;
            default:
                result = Double.NaN;
        }
    }

    public String getOperand() {
        return operand;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public double getResult() {
        return result;
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