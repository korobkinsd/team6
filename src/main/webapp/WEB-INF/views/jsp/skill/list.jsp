<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<jsp:include page="../layouts/header.jsp"/>

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

	<h1>Skills</h1>

	<table class="table table-striped">
		<thead>
		<tr>
			<th>
				<a href="?columnName=NAME&order=${order}&page=${pageNumber}">Skills</a>
			</th>
		</tr>



		<form:form class="form-horizontal" method="get" modelAttribute="skillForm" action="${skillActionUrl}">
			<tr>
				<th><spring:bind path="skill">
					<form:input path="skill" type="text" class="form-control " id="skill"  placeholder="skill"/>
				</spring:bind></th>

				<th>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">

							<button type="submit" class="btn-lg btn-primary pull-right">Change</button>

						</div>
					</div>
				</th>
			</tr>
		</form:form>

		</thead>

		<c:forEach var="skill" items="${skill}">
			<tr>
				<td>${skill.skill}</td>
				<td>
					<spring:url value="/skill/${skill.skill}" var="skillUrl"/>
					<spring:url value="/skill/${skill.skill}/delete" var="deleteUrl"/>
					<spring:url value="/skill/${skill.skill}/update" var="updateUrl"/>

					<button class="btn btn-info" onclick="location.href='${skillUrl}'">Show</button>
					<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
					<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
				</td>

			</tr>
		</c:forEach>
	</table>

</div>

<jsp:include page="../layouts/footer.jsp"/>

</body>
</html>