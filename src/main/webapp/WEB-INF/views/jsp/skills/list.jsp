<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">


<jsp:include page="../layouts/header.jsp"/>
<body>


<div class="container"><br><br><br>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>skills</h1>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <spring:url value="/skills/add" var="urlAddSkill" />
                <li class="active"><a href="${urlAddSkill}"><spring:message code="button.add"/></a></li>
            </ul>
        </div>

	<table class="table table-striped">
		<thead>
		<%--<tr>--%>
			<%--<th>--%>
				<%--<a href="?columnName=NAME&order=${order}&page=${pageNumber}">Skills</a>--%>
			<%--</th>--%>
		<%--</tr>--%>



		<form:form class="form-horizontal" method="get" modelAttribute="skillForm" action="${skillActionUrl}">
			<tr>
				<th><spring:bind path="name">
					<form:input path="name" type="text" class="form-control " id="name"  placeholder="name"/>
				</spring:bind></th>

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

		<c:forEach var="skill" items="${skills}">
			<tr>
				<td>${skill.name}</td>
				<td>
					<spring:url value="/skills/${skill.name}" var="skillUrl"/>
					<spring:url value="/skills/${skill.name}/delete" var="deleteUrl"/>
					<spring:url value="/skills/${skill.name}/update" var="updateUrl"/>

					<button class="btn btn-info" onclick="location.href='${skillUrl}'">Show</button>
					<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
					<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
				</td>

			</tr>
		</c:forEach>
	</table>
	</main>
</div>

<jsp:include page="../layouts/footer.jsp"/>

</body>
</html>