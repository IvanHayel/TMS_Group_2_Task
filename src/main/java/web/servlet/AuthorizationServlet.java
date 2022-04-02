package web.servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", value = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    private static final UserService userService = UserService.getInstance();

    private static final String AUTHORIZATION_PAGE_PATH = "/pages/authorization.jsp";
    private static final String HOME_PATH = "/";
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String USER_ATTRIBUTE = "user";

    private transient HttpSession session;

    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        session = req.getSession();
        User currentUser = (User) session.getAttribute(USER_ATTRIBUTE);
        if (currentUser != null) resp.sendRedirect(HOME_PATH);
        else req.getRequestDispatcher(AUTHORIZATION_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        session = req.getSession();
        String login = req.getParameter(LOGIN_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        if (login == null || password == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else if (userService.isLoginExist(login)) {
            User user = userService.find(login);
            if (user.getPassword().equals(password)) {
                session.setAttribute(USER_ATTRIBUTE, user);
            }
            doGet(req, resp);
        }
    }
}