package web.servlet.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Error400Servlet", value = "/error-400")
public class Error400Servlet extends HttpServlet {
        private static final String ERROR_400_PATH = "/pages/error/400.html";

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(ERROR_400_PATH);
            requestDispatcher.forward(req,resp);
        }
    }

