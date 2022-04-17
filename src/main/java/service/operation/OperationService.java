package service.operation;

import entity.Operation;

import java.util.Collection;

public interface OperationService {
    Collection<Operation> getAll();

    boolean save(Operation operation);

    Operation calculate(Operation operation);
}