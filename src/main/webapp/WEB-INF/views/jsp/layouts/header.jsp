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

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">List Users</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add User</a></li>
			</ul>
		</div>
	</div>
</nav>