package web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static constant.CalculatorWebConstants.PATH_HOME;
import static constant.CalculatorWebConstants.PATH_LOGOUT;

@WebServlet(name = "LogoutServlet", value = PATH_LOGOUT)
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(PATH_HOME);
        req.getSession().invalidate();
    }
}