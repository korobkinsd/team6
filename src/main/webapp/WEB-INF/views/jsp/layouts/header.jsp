<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Team 6</title>
	<meta charset="utf-8">
	<spring:url value="${pageContext.request.contextPath}/resources/core/css/core.css" var="coreCss" />
	<spring:url value="${pageContext.request.contextPath}/resources/core/lib/bootstrap/css/bootstrap.min.css"	var="bootstrapCss" />
	<spring:url value="${pageContext.request.contextPath}/resources/core/lib/bootstrap/css/dashboard.css"	var="dashboardCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
	<link href="${dashboardCss}" rel="stylesheet" />
</head>

<div class="container">
	<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
		<div class="navbar-brand col-sm-3 col-md-2 mr-0"> Job&Staff </div>
		<jsp:include page="../layouts/menu.jsp" />
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap">
				<span style="float: right">
					<a href="?lang=en">en</a>
					<a href="?lang=ru">ru</a>
				</span>
			</li>
		</ul>
	</nav>
</div>


	<!--nav class="navbar navbar-inverse ">
	<div class="container">

		< div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">List Users</a>
			<a class="navbar-brand" href="${urlVacancy}">List Vacancy</a>
		</div>


		<div clsdd="navbar-brand">
		<span style="float: right">
			<a href="?lang=en">en</a>
			<a href="?lang=ru">ru</a>
			</span>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add User</a></li>
				<li class="active"><a href="${urlAddVacancy}">Add vacancy</a></li>
				<li class="active"><a href="${urlAddUser}"><spring:message code="button.add"/></a></li>
			</ul>
		</div>
	</div>
</nav -->