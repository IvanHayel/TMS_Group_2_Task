package service.operation;

import entity.Operation;
import lombok.NonNull;
import storage.EntityStorage;
import storage.EntityStorageImpl;

import java.util.ArrayList;
import java.util.Collection;

public class OperationServiceImpl implements OperationService {
    private static final Collection<Operation> DEFAULT_OPERATION_STORAGE_COLLECTION = new ArrayList<>();
    private static final EntityStorage<Operation> OPERATION_STORAGE =
            new EntityStorageImpl<>(DEFAULT_OPERATION_STORAGE_COLLECTION);

    private static OperationServiceImpl instance;

    private OperationServiceImpl() {
    }

    public static OperationServiceImpl getInstance() {
        if (instance == null) instance = new OperationServiceImpl();
        return instance;
    }

    @Override
    public Collection<Operation> getAll() {
        return OPERATION_STORAGE.getAll();
    }

    @Override
    public boolean save(Operation operation) {
        return OPERATION_STORAGE.save(operation);
    }

    @Override
    public Operation calculate(@NonNull Operation operation) {
        @NonNull String operand = operation.getOperand();
        double firstValue = operation.getFirstValue();
        double secondValue = operation.getSecondValue();
        switch (operand) {
            case "+":
            case "add":
            case "sum":
                operation.setResult(firstValue + secondValue);
                break;
            case "-":
            case "sub":
            case "subtract":
                operation.setResult(firstValue - secondValue);
                break;
            case "*":
            case "mult":
            case "multiply":
                operation.setResult(firstValue * secondValue);
                break;
            case "/":
            case "div":
            case "divide":
                operation.setResult(firstValue / secondValue);
                break;
            default:
                operation.setResult(Double.NaN);
        }
        return operation;
    }
}