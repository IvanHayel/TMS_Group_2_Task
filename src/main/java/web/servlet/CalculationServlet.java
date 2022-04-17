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

import static constant.CalculatorWebConstants.*;

@WebServlet(name = "CalculationServlet", value = PATH_CALCULATION)
public class CalculationServlet extends HttpServlet {
    private static final OperationService OPERATION_SERVICE = OperationServiceImpl.getInstance();

    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(PAGE_PATH_CALCULATION).forward(req, resp);
    }

    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        @NonNull String operand = req.getParameter(REQUEST_PARAMETER_OPERAND);
        @NonNull String firstValueUnparsed = req.getParameter(REQUEST_PARAMETER_FIRST_VALUE);
        @NonNull String secondValueUnparsed = req.getParameter(REQUEST_PARAMETER_SECOND_VALUE);
        Operation operation = new Operation();
        operation.setOperand(operand);
        operation.setFirstValue(Double.parseDouble(firstValueUnparsed));
        operation.setSecondValue(Double.parseDouble(secondValueUnparsed));
        Operation calculatedOperation = OPERATION_SERVICE.calculate(operation);
        if (OPERATION_SERVICE.save(calculatedOperation)) {
            req.setAttribute(REQUEST_ATTRIBUTE_OPERATION, calculatedOperation);
            req.getRequestDispatcher(PAGE_PATH_CALCULATION).forward(req, resp);
        } else resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}