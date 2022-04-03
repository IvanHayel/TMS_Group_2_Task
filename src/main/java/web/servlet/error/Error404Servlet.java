package web.servlet.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Error404Servlet", value = "/error-404")

    public class Error404Servlet extends HttpServlet {
        private static final String ERROR_404_PATH = "/pages/error/404.html";
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(ERROR_404_PATH);
            requestDispatcher.forward(req,resp);
        }
    }

