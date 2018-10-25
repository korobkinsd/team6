<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>
<jsp:include page="../layouts/header.jsp" />
<div class="container-fluid">
	<br><br>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<h1>Candidate's profile</h1>
		<br />
		<div class="row">
			<label class="col-sm-2"><spring:message code="label.table.column.candidate_id"/></label>
			<div class="col-sm-10">${candidate.id}</div>
		</div>
		<div class="row">
			<label class="col-sm-2"><spring:message code="label.table.column.candidate_name"/></label>
			<div class="col-sm-10">${candidate.name}</div>
		</div>
		<div class="row">
			<label class="col-sm-2"><spring:message code="label.table.column.candidate_surname"/></label>
			<div class="col-sm-10">${candidate.surname}</div>
		</div>
		<div class="row">
			<label class="col-sm-2"><spring:message code="label.table.column.candidate_salary"/></label>
			<div class="col-sm-10">${candidate.salary}</div>
		</div>
		<div class="row">
			<label class="col-sm-2"><spring:message code="label.table.column.candidate_birthday"/></label>
			<div class="col-sm-10">${candidate.birthdayAsString}</div>
		</div>
		<div class="row">
			<label class="col-sm-2"><spring:message code="label.table.column.candidate_state"/></label>
			<div class="col-sm-10">${candidate.candidateState.description}</div>
		</div>

	</main>
</div>
<jsp:include page="../layouts/footer.jsp" />
</body>
</html>