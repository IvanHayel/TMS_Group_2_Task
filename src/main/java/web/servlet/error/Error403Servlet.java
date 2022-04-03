package web.servlet.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Error403Servlet", value = "/error-403")
public class Error403Servlet extends HttpServlet {
    private static final String ERROR_403_PATH = "/pages/error/403.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ERROR_403_PATH);
        requestDispatcher.forward(req,resp);
    }
}
