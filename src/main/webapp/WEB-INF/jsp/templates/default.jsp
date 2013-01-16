<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<spring:eval var="useCDN" expression="@settings.getProperty('useCDN')" />
<spring:eval var="useWebTracking" expression="@settings.getProperty('useWebTracking')" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title><spring:message code="text.title"/></title>

    <link href="<c:url value='/lib/bootstrap/2.2.2/css/bootstrap.min.css' />" rel="stylesheet"/>
    <!--
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>
    -->
    <spring:theme var="themeStyleSheetUrl" code="css.url"/>
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='${themeStyleSheetUrl}' />" rel="stylesheet"/>


    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <c:choose>
        <c:when test="${useCDN}">
            <script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js' />"></script>
        </c:when>
        <c:otherwise>
            <script src="<c:url value='/lib/jquery/1.8.3/jquery.min.js' />"></script>
        </c:otherwise>
    </c:choose>

    <script src="<c:url value='/lib/bootstrap/2.2.2/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/js/app.js' />"></script>
    <!--
    <script src="<c:url value='https://localhost:8443/dev/js/app.js' />"></script>
    -->

    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico' />"/>
</head>

<body>
<div class="navbar navbar-fixed-top navbar-inverse">
    <tiles:insertAttribute name="navigation"/>
</div>
<div class="container">
    <tiles:insertAttribute name="body"/>
    <footer>
        <tiles:insertAttribute name="footer"/>
    </footer>
</div>
</body>

</html>
