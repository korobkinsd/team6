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
<spring:url value="/skills" var="urlSkills" />
<spring:url value="/interview" var="urlInterview" />
<div class="nav-scroller py-1 mb-2">
    <nav class="nav d-flex justify-content-between">
            <a class="p-2 text-white" href="/">Home</a>
            <a class="p-2 text-white" href="${urlUsers}"><spring:message code="label.menu.users"/></a>
            <a class="p-2 text-white" href="${urlVacancy}"><spring:message code="label.menu.vacancy"/></a>
            <a class="p-2 text-white" href="${urlCandidates}"><spring:message code="label.menu.candidates"/></a>
            <a class="p-2 text-white" href="${urlSkills}"><spring:message code="label.menu.skills"/></a>
            <a class="p-2 text-white" href="${urlIntervew}"><spring:message code="label.menu.interview"/></a>
            <a class="p-2 text-white" href="/about">About</a>
    </nav>
</div>