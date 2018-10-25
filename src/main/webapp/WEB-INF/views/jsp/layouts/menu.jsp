<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Team 6</title>
    <meta charset="utf-8">
    <spring:url value="/resources/core/css/core.css" var="coreCss" />
    <spring:url value="/resources/core/lib/bootstrap/css/bootstrap.min.css"	var="bootstrapCss" />
    <spring:url value="/resources/core/lib/bootstrap/css/dashboard.css"	var="dashboardCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
    <link href="${dashboardCss}" rel="stylesheet">

</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/candidates" var="urlCandidates" />
<spring:url value="/vacancy" var="urlVacancy" />
<spring:url value="/users" var="urlUsers" />
<div class="container-fluid">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
        <div class="sidebar-sticky">
            <ul class="nav flex-column">
                <li class="nav-item"><br><br></li>
                <li class="nav-divider"/>
                <li class="nav-item">
                    <a class="menu-item" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="menu-item" href="${urlUsers}">List Users</a>
                </li>
                <li class="nav-item">
                    <a class="menu-item" href="${urlVacancy}">List Vacancy</a>
                </li>
                <li class="nav-item">
                    <a class="menu-item" href="${urlCandidates}"><spring:message code="label.menu.candidates"/></a>
                </li>
                <li class="nav-item">
                    <a class="menu-item" href="/about">About</a>
                </li>
            </ul>
        </div>
    </nav>
</div>