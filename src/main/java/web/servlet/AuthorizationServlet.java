package web.servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;
import lombok.SneakyThrows;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.io.IOException;

import static constant.CalculatorWebConstants.*;

@WebServlet(name = "AuthorizationServlet", value = PATH_AUTHORIZATION)
public class AuthorizationServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserServiceImpl.getInstance();

    private transient HttpSession session;

    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        session = req.getSession();
        User currentUser = (User) session.getAttribute(SESSION_ATTRIBUTE_USER);
        if (currentUser != null) resp.sendRedirect(PATH_HOME);
        else req.getRequestDispatcher(PAGE_PATH_AUTHORIZATION).forward(req, resp);
    }

    @Override
    @SneakyThrows(IOException.class)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        session = req.getSession();
        @NonNull String login = req.getParameter(REQUEST_PARAMETER_LOGIN);
        @NonNull String password = req.getParameter(REQUEST_PARAMETER_PASSWORD);
        if (USER_SERVICE.isLoginExist(login)) {
            User user = USER_SERVICE.get(login);
            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute(SESSION_ATTRIBUTE_USER, user);
                resp.sendRedirect(PATH_HOME);
            } else resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else resp.sendRedirect(PATH_AUTHORIZATION);
    }
}