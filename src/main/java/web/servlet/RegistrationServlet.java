package web.servlet;

import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        if (login == null || password == null || surname == null || name == null) {
            // TODO: If one of the parameters is not received.
        } else {
            if (userService.isLoginExist(login)) {
                // TODO: If login already exists.
            } else {
                User user = new User(login, password, name, surname);
                if(userService.save(user)){
                    // TODO: If save successfully ended.
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    // TODO: If not saved.
                }
            }
        }
    }
}