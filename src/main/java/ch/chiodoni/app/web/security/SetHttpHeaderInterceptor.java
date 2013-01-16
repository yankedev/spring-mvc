package ch.chiodoni.app.web.security;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/14/13
 * Time: 7:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class SetHttpHeaderInterceptor extends HandlerInterceptorAdapter {

    private boolean enabled = true;

    private Map<String, String> headers;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (enabled) {
            for (String key : headers.keySet()) {
                ((HttpServletResponse) response).setHeader(key, headers.get(key));
            }
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

}
