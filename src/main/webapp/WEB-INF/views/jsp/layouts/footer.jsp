<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div class="container">

	<nav class="navbar navbar-dark fixed-bottom bg-dark flex-md-nowrap p-0 shadow">
	<!--div class="container" -->
		<ul class="pagination justify-content-center">
			<!-- label class="col-sm-2 control-label">${pageCount}</label -->
			<c:forEach begin="1" end="${pageCount}" varStatus="loop">
				<li class="page-item"><a class="page-link" href="?columnName=${columnName}&order=${order}&page=${loop.index}">${loop.index}</a></li>
			</c:forEach>
		</ul>


			<p class="p-2 text-white">&copy; team6.com 2019</p>

	<!-- /div -->
	</nav>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/lib/jquery/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/core/js/core.js" var="coreJs" />
<spring:url value="/resources/core/lib/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${jqueryJs}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


