<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">



<body>
	<jsp:include page="../layouts/header.jsp" />


			<jsp:include page="../layouts/menu.jsp" />
			<div class="container-fluid">
				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				<c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if>
				<h1><spring:message code="label.table.title.candidates"/></h1>
					<div id="navbar">
						<ul class="nav navbar-nav navbar-right">
							<spring:url value="/candidates/add" var="urlAddCandidate" />
							<li class="active"><a href="${urlAddCandidate}"><spring:message code="button.add"/></a></li>
						</ul>
					</div>
					<div class="table-responsive">
						<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="label.table.column.candidate_id"/></th>
								<th><spring:message code="label.table.column.candidate_name"/></th>
								<th><spring:message code="label.table.column.candidate_surname"/></th>
								<th><spring:message code="label.table.column.candidate_salary"/></th>
								<th><spring:message code="label.table.column.candidate_birthday"/></th>
								<th><spring:message code="label.table.column.candidate_state"/></th>
								<th><spring:message code="label.table.column.action"/></th>
							</tr>
						</thead>

						<c:forEach var="candidate" items="${candidates}">
							<tr>
								<td>${candidate.id}</td>
								<td>${candidate.name}</td>
								<td>${candidate.surname}</td>
								<td>${candidate.salary}</td>
								<td>${candidate.birthdayAsString}</td>
								<td>${candidate.candidateState.description}</td>
								<td>
									<spring:url value="/candidates/${candidate.id}" var="showUrl" />
									<spring:url value="/candidates/${candidate.id}/delete" var="deleteUrl" />
									<spring:url value="/candidates/${candidate.id}/update" var="updateUrl" />

									<button class="btn btn-info" onclick="location.href='${showUrl}'">Show</button>
									<button class="btn btn-primary" onclick="location.href='${updateUrl}'"><spring:message code="button.update"/></button>
									<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')"><spring:message code="button.delete"/></button></td>
							</tr>
						</c:forEach>
						</table>
					</div>
				</main>
			</div>


	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>