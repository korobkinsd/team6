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
	<c:choose>
		<c:when test="${candidateForm['new']}">
			<h1>Add Candidate's profile</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Candidate's profile</h1>
		</c:otherwise>
	</c:choose>
	<br/>

		<spring:url value="/candidates" var="candidateActionUrl" />

		<form:form class="form-horizontal" method="post" modelAttribute="candidateForm" action="${candidateActionUrl}">

			<form:hidden path="id" />

			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label"><spring:message code="label.table.column.candidate_name"/></label>
					<div class="col-sm-10">
						<form:input path="name" type="text" class="form-control " id="name" placeholder="name" />
						<form:errors path="name" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="surname">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label"><spring:message code="label.table.column.candidate_surname"/></label>
					<div class="col-sm-10">
						<form:input path="surname" class="form-control" id="surname" placeholder="surname" />
						<form:errors path="surname" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="salary">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label"><spring:message code="label.table.column.candidate_salary"/></label>
					<div class="col-sm-10">
						<form:input path="salary" class="form-control" id="salary" placeholder="salary" />
						<form:errors path="salary" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<!--spring:bind path="birthday" -->
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label"><spring:message code="label.table.column.candidate_birthday"/></label>
					<div class="col-sm-10">
						<form:input path="birthdayAsString" class="form-control" />
						<form:errors path="birthdayAsString" class="control-label" />
					</div>
				</div>
			<!-- /spring:bind-->

			<spring:bind path="candidateState">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label"><spring:message code="label.table.column.candidate_state"/></label>
					<div class="col-sm-10">
						<form:select path="candidateState" class="form-control" id="candidateState">
							<c:forEach items="${listCandidateState}" var="listOfStates">
								<option   ${listOfStates == candidateForm.candidateState ? 'selected' : ''} value="${listOfStates}">${listOfStates.description}</option>
							</c:forEach>
						</form:select>
						<!-- form:input path="candidateState" class="form-control" id="candidateState" placeholder="candidateState" / -->
						<form:errors path="candidateState" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${candidateForm['new']}">
							<button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="button.add"/></button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="button.update"/></button>
						</c:otherwise>
					</c:choose>
					<a href="javascript:history.back()"><spring:message code="button.cancel" /></a>
				</div>
			</div>
		</form:form>
	</main>>

</div>
<jsp:include page="../layouts/footer.jsp" />
</body>
</html>