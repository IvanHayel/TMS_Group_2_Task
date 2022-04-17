package web.servlet;

import entity.Operation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.SneakyThrows;
import service.operation.OperationService;
import service.operation.OperationServiceImpl;

import java.io.IOException;
import java.util.Collection;

import static constant.CalculatorWebConstants.*;

@WebServlet(name = "CalculationHistoryServlet", value = PATH_CALCULATION_HISTORY)
public class CalculationHistoryServlet extends HttpServlet {
    private static final OperationService OPERATION_SERVICE = OperationServiceImpl.getInstance();

    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        @NonNull Collection<Operation> allOperations = OPERATION_SERVICE.getAll();
        req.setAttribute(REQUEST_ATTRIBUTE_OPERATION_HISTORY, allOperations);
        req.getRequestDispatcher(PAGE_PATH_CALCULATION_HISTORY).forward(req, resp);
    }
}