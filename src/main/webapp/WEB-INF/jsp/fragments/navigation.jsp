<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<div class="navbar-inner">
    <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <a class="brand" href="#"><spring:message code="text.title"/></a>

        <div class="nav-collapse">
            <ul class="nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message
                            code="menu.changelanguage"/> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='?lang=de'/>"><spring:message code="lang.german"/></a></li>
                        <li><a href="<c:url value='?lang=fr'/>"><spring:message code="lang.french"/></a></li>
                        <li><a href="<c:url value='?lang=it'/>"><spring:message code="lang.italian"/></a></li>
                        <li><a href="<c:url value='?lang=en'/>"><spring:message code="lang.english"/></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>