package web.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

import static constant.CalculatorWebConstants.PAGE_PATH_HOME;
import static constant.CalculatorWebConstants.PATH_HOME;

@WebServlet(name = "HomeServlet", value = PATH_HOME)
public class HomeServlet extends HttpServlet {
    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PAGE_PATH_HOME);
        requestDispatcher.forward(req, resp);
    }
}