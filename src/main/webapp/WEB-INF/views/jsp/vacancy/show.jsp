<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>


<jsp:include page="../layouts/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>vacancy Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${vacancy.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">position</label>
		<div class="col-sm-10">${vacancy.position}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">idDeveloper</label>
		<div class="col-sm-10">${vacancy.idDeveloper}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">salaryFrom</label>
		<div class="col-sm-10">${vacancy.salaryFrom}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">salaryTo</label>
		<div class="col-sm-10">${vacancy.salaryTo}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">salaryTo</label>
		<div class="col-sm-10">${vacancy.experienceYearsRequire}</div>
	</div>
</div>

<jsp:include page="../layouts/footer.jsp" />

</body>
</html>