<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../layouts/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th><a href="?columnName=name&order=${order}&page=${pageNumber}">Name</a></th>
					<th><a href="?columnName=email&order=${order}&page=${pageNumber}">Email</a></th>
					<th><a href="?columnName=surname&order=${order}&page=${pageNumber}">Surname</a></th>
					<th>Action</th>
				</tr>

				<form:form class="form-horizontal" method="get" modelAttribute="userForm" action="${userActionUrl}">
					<tr>
						<th><spring:bind path="name">

							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control " id="name"
											placeholder="name"/>
							</div>
						</spring:bind>
						</th>
						<th><spring:bind path="email">

							<div class="col-sm-10">
								<form:input path="email" type="text" class="form-control " id="email"
											placeholder="email"/>
							</div>
						</spring:bind>
						</th>
						<th><spring:bind path="surname">

							<div class="col-sm-10">
								<form:input path="surname" type="text" class="form-control " id="surname"
											placeholder="surname"/>
							</div>
						</spring:bind>
						</th>
						<th>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn-lg btn-primary pull-right">Apply filtering</button>
								</div>
							</div>
						</th>
					</tr>
				</form:form>
			</thead>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.surname}</td>
					<td>
						<spring:url value="/users/${user.id}" var="userUrl" />
						<spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
						<spring:url value="/users/${user.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">Show</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../layouts/footer.jsp" />

</body>
</html>