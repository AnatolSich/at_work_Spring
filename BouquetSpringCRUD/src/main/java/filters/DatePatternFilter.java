package filters;

import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static util.Constants.DATE_PATTERN;

//@WebFilter
public class DatePatternFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setAttribute("datePattern",DATE_PATTERN);
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
