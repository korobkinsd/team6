<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Team 6</title>
	<meta charset="utf-8">
	<spring:url value="/resources/core/css/core.css" var="coreCss" />
	<spring:url value="/resources/core/lib/bootstrap/css/bootstrap.min.css"	var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<spring:url value="/vacancy" var="urlVacancy" />
<spring:url value="/vacancy/add" var="urlAddVacancy" />
<spring:url value="/skill" var="urlSkill" />
<spring:url value="/skill/add" var="urlAddSkill" />
<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">List Users</a>
			<a class="navbar-brand" href="${urlVacancy}">List Vacancy</a>
			<a class="navbar-brand" href="${urlSkill}">List of skills</a>
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
				<li class="active"><a href="${urlAddSkill}">Add skill</a></li>
			</ul>
		</div>

	</div>
</nav>