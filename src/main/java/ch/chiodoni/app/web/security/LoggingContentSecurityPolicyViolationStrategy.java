package ch.chiodoni.app.web.security;

import ch.chiodoni.app.config.Loggers;
import com.google.common.io.CharStreams;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/14/13
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoggingContentSecurityPolicyViolationStrategy implements ContentSecurityPolicyViolationStrategy {

    @Override
    public void report(String type, HttpServletRequest request) {
        try {
            String violator = request.getRemoteAddr();
            if (StringUtils.hasText(request.getRemoteUser())) {
                violator = violator + "(" + request.getRemoteAddr() + ")";
            }
            String violation = CharStreams.toString(new InputStreamReader(request.getInputStream(), "UTF-8"));
            Loggers.SECURITY_LOGGER.warn("CSP violation of type " + type + " from ({}): {}", violator, violation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
