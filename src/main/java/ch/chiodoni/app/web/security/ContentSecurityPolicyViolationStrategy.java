package ch.chiodoni.app.web.security;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 1/14/13
 * Time: 8:55 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContentSecurityPolicyViolationStrategy {

    public void report(String type, HttpServletRequest request);

}
