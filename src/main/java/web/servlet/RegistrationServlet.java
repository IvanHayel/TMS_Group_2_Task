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

@WebServlet(name = "RegistrationServlet", value = PATH_REGISTRATION)
public class RegistrationServlet extends HttpServlet {
    private static final UserService USER_SERVICE = UserServiceImpl.getInstance();

    private transient HttpSession session;

    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        session = req.getSession();
        User currentUser = (User) session.getAttribute(SESSION_ATTRIBUTE_USER);
        if (currentUser != null) resp.sendRedirect(PATH_HOME);
        else req.getRequestDispatcher(PAGE_PATH_REGISTRATION).forward(req, resp);
    }

    @Override
    @SneakyThrows(IOException.class)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        session = req.getSession();
        @NonNull String login = req.getParameter(REQUEST_PARAMETER_LOGIN);
        @NonNull String password = req.getParameter(REQUEST_PARAMETER_PASSWORD);
        @NonNull String name = req.getParameter(REQUEST_PARAMETER_NAME);
        @NonNull String surname = req.getParameter(REQUEST_PARAMETER_SURNAME);
        if (!USER_SERVICE.isLoginExist(login)) {
            User userToRegister = new User(login, password, name, surname);
            if (USER_SERVICE.save(userToRegister)) resp.sendRedirect(PATH_AUTHORIZATION);
            else resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } else resp.sendRedirect(PATH_REGISTRATION);
    }
}