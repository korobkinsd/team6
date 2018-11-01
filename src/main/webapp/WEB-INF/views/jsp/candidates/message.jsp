<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<body>
	<jsp:include page="../layouts/header.jsp" />

			<div class="container"><br><br><br>
				<main role="main" class="col-md-9 ml-sm-auto col-sm-10 px-4">
					<spring:url value="/candidates" var="candidateActionUrl" />
					<form:form class="form-horizontal" method="post" action="${candidateActionUrl}">

						<c:if test="${not empty msg}">
							<div class="alert alert-${css} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${msg}</strong>
							</div>
						</c:if>
			
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="button.add"/></button>
								<a href="javascript:history.back()"><spring:message code="button.cancel" /></a>
							</div>
						</div>
					</form:form>
				</main>
			</div>


	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>