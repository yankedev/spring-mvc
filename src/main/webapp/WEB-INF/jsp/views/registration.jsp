<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<div ng-controller="AddressCtrl">
    <form:form modelAttribute="user" cssClass="form-horizontal" method="post">
        <fieldset id="user">
            <legend><spring:message code="legend.user" /></legend>
            <t:input path="name" required="true" label="label.name" cssClass="span4" type="text"/>
            <t:input path="lastName" required="true" label="label.lastName" cssClass="span4" type="text"/>
            <t:input path="email" required="true" label="label.email" cssClass="span4" type="email"/>
            <t:input path="phone" required="true" label="label.phone" cssClass="span4" type="text"/>
            <t:input path="birthday" required="false" label="label.birthday" cssClass="span4" type="date"/>
            <spring:bind path="country">
                <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
                    <label class="control-label" for="country"><spring:message code="label.country"/></label>
                    <div class="controls">
                        <form:select id="country" path="country" class="span4">
                            <form:option selected="true" value=""><spring:message code="text.chose.country"/> </form:option>
                            <c:forEach items="${countries}" var="country">
                                <form:option value="${country.code}">${country.name}</form:option>
                            </c:forEach>
                        </form:select>
                        <span class="help-inline"></span>
                    </div>
                </div>
            </spring:bind>
        </fieldset>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary"><spring:message code="button.register"/></button>
            </div>
        </div>
    </form:form>
</div>