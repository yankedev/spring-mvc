package ch.chiodoni.app.config;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/17/13
 * Time: 6:58 PM
 *
 * Simple MDC filter.
 *
 */
public class MDCLoggingFilter implements Filter {

    private final String ADDRESS = "ipAddress";
    private final String USERNAME = "username";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String username = ((HttpServletRequest) request).getRemoteUser();
            if (! StringUtils.hasText(username)) {
                username = "anonymous";
            }
            MDC.put(USERNAME, username);
            MDC.put(ADDRESS, request.getRemoteAddr());
            chain.doFilter(request, response);
        } finally {
            MDC.remove(ADDRESS);
            MDC.remove(USERNAME);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}

