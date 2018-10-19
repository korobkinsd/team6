<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

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

		<h1>All Vacancy</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>position</th>
					<th>idDeveloper</th>
					<th>salaryFrom</th>
					<th>salaryTo</th>
					<th>experienceYearsRequire</th>
				</tr>
			</thead>

			<c:forEach var="vacancy" items="${vacancy}">
				<tr>
					<td>
						${vacancy.id}
					</td>
					<td>${vacancy.position}</td>
					<td>${vacancy.idDeveloper}</td>
					<td>${vacancy.salaryFrom}</td>
					<td>${vacancy.salaryTo}</td>
                    <td>${vacancy.experienceYearsRequire}</td>

					<td>
						<spring:url value="/vacancy/${vacancy.id}" var="vacancyUrl" />
						<spring:url value="/vacancy/${vacancy.id}/delete" var="deleteUrl" />
						<spring:url value="/vacancy/${vacancy.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${vacancyUrl}'">Show</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>

				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../layouts/footer.jsp" />

</body>
</html>