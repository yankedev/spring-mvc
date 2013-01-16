<%@tag description="Extended input tag to allow for sophisticated errors" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="true" type="java.lang.String"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="required" required="true" type="java.lang.Boolean" %>
<spring:bind path="${path}">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
        <label class="control-label" for="${path}"><spring:message code="${label}"/><c:if test="${required}"><span class="required"> *</span></c:if></label>
        <div class="controls">
            <form:input autofocus="autofocus" id="${path}" path="${path}" class="${cssClass}" type="${type}"></form:input>
            <span class="help-inline"><form:errors path="${path}"/></span>
        </div>
    </div>
</spring:bind>