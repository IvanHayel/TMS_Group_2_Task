package web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;

import static constant.CalculatorWebConstants.SESSION_ATTRIBUTE_USER;

@WebFilter(servletNames = {"CalculationServlet", "CalculationHistoryServlet"})
public class AuthorizationFilter extends HttpFilter {
    @Override
    @SneakyThrows({IOException.class, ServletException.class})
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
        HttpSession session = req.getSession();
        if (session.getAttribute(SESSION_ATTRIBUTE_USER) == null)
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        else
            chain.doFilter(req, resp);
    }
}