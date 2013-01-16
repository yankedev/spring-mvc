package ch.chiodoni.app.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/14/13
 * Time: 7:13 AM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * As defined by http://www.w3.org/TR/CSP/
 */
@Controller
public class ContentSecurityPolicyViolationsReportingController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContentSecurityPolicyViolationsReportingController.class);

    @Autowired
    private ContentSecurityPolicyViolationStrategy violationStrategy;

    @RequestMapping(value = "/csp/{violationType}", method = RequestMethod.POST, consumes = "application/json")
    public void reportViolation(@PathVariable String violationType, HttpServletRequest request, HttpServletResponse response) {
        violationStrategy.report(violationType, request);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
