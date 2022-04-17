package web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebFilter(filterName = "JspFilter", urlPatterns = "*.jsp")
public class JspFilter extends HttpFilter {
    @Override
    @SneakyThrows(IOException.class)
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
        resp.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}