<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">



<body>
<jsp:include page="layouts/header.jsp" />
<div class="container-fluid">
	<br><br>
		<h1>Error Page</h1>

		<p>${exception.message}</p>
		${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>
</div>
<jsp:include page="layouts/footer.jsp" />
</body>
</html>