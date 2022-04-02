package web.servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final UserService userService = UserService.getInstance();

    private static final String REGISTRATION_PAGE_PATH = "/pages/registration.jsp";
    private static final String AUTHORIZATION_PATH = "/authorization";
    private static final String HOME_PATH = "/";
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String NAME_PARAMETER = "name";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String USER_ATTRIBUTE = "user";

    private transient HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        User currentUser = (User) session.getAttribute(USER_ATTRIBUTE);
        if (currentUser != null) resp.sendRedirect(HOME_PATH);
        else req.getRequestDispatcher(REGISTRATION_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        session = req.getSession();
        String login = req.getParameter(LOGIN_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        String name = req.getParameter(NAME_PARAMETER);
        String surname = req.getParameter(SURNAME_PARAMETER);
        if (login == null || password == null || name == null || surname == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else if (!userService.isLoginExist(login)) {
            User userToRegister = new User(login, password, name, surname);
            if (userService.save(userToRegister)) {
                resp.sendRedirect(AUTHORIZATION_PATH);
            } else throw new IllegalStateException();
        } else doGet(req, resp);
    }
}