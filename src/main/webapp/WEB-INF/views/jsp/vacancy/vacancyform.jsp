<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>


<jsp:include page="../layouts/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${vacancyForm['new']}">
			<h1><spring:message code="label.title.addVacancy"/></h1>
		</c:when>
		<c:otherwise>
			<h1><spring:message code="label.title.updateVacancy"/></h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/vacancy" var="vacancyActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="vacancyForm" action="${vacancyActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="position">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label"><spring:message code="label.table.column.vacancy.position"/></label>
				<div class="col-sm-10">
					<form:input path="position" type="text" class="form-control " id="position" placeholder="position" />

					<form:errors path="position" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="idDeveloper">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label"><spring:message code="label.table.column.vacancy.IdDeveloper"/></label>
				<div class="col-sm-10">
					<form:select path="idDeveloper" class="form-control" id="idDeveloper">
						<c:forEach items="${listOfUsers}" var="listOfUsers">
							<option   ${listOfUsers.id == vacancyForm.idDeveloper ? 'selected' : ''} value="${listOfUsers.id}">${listOfUsers.name}</option>
						</c:forEach>
					</form:select>
					<form:errors path="idDeveloper" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="salaryFrom">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label"><spring:message code="label.table.column.vacancy.salary_from"/></label>
				<div class="col-sm-10">
					<form:input path="salaryFrom" class="form-control" id="salaryTo" placeholder="salaryFrom" />
					<form:errors path="salaryFrom" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="salaryTo">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label"><spring:message code="label.table.column.vacancy.salary_to"/></label>
				<div class="col-sm-10">
					<form:input path="salaryTo" rows="5" class="form-control" id="salaryTo" placeholder="salaryTo" />
					<form:errors path="salaryTo" class="control-label" />
				</div>
			</div>
		</spring:bind>

        <spring:bind path="experienceYearsRequire">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="label.table.column.vacancy.ExperienceYearsRequire"/></label>
                <div class="col-sm-10">
                    <form:input path="experienceYearsRequire" rows="5" class="form-control" id="experienceYearsRequire" placeholder="experienceYearsRequire" />
                    <form:errors path="experienceYearsRequire" class="control-label" />
                </div>
            </div>
        </spring:bind>


		<spring:bind path="state">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label"><spring:message code="label.table.column.vacancy.state"/></label>
				<div class="col-sm-10">
					<form:select path="state" class="form-control" id="state">
						<c:forEach items="${vacancyState}" var="value">
							<option     value="${value.toString()}">${value.toString()}</option>
						</c:forEach>
					</form:select>
					<form:errors path="state" class="control-label" />
				</div>
			</div>
		</spring:bind>





		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${vacancyForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="button.add"/></button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="button.update"/></button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>



</body>
<footer><jsp:include page="../layouts/footer.jsp" /></footer>
</html>