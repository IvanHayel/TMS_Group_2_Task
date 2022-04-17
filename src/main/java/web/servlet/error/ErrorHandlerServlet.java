package web.servlet.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import static constant.CalculatorWebConstants.*;

@WebServlet(urlPatterns = "/error/*")
public class ErrorHandlerServlet extends HttpServlet {
    private static final String SLASH_SYMBOL = "/";

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String requestURI = req.getRequestURI();
        int lastIndexOfSlash = requestURI.lastIndexOf(SLASH_SYMBOL);
        int errorNumber = Integer.parseInt(requestURI.substring(++lastIndexOfSlash));
        RequestDispatcher dispatcher = null;
        switch (errorNumber) {
            case HttpServletResponse.SC_BAD_REQUEST:
                dispatcher = req.getRequestDispatcher(PAGE_PATH_ERROR_400);
                break;
            case HttpServletResponse.SC_UNAUTHORIZED:
                dispatcher = req.getRequestDispatcher(PAGE_PATH_ERROR_401);
                break;
            case HttpServletResponse.SC_FORBIDDEN:
                dispatcher = req.getRequestDispatcher(PAGE_PATH_ERROR_403);
                break;
            case HttpServletResponse.SC_NOT_FOUND:
                dispatcher = req.getRequestDispatcher(PAGE_PATH_ERROR_404);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        if (dispatcher != null) dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}