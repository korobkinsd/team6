<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
	<hr>
	<footer>
		<p>&copy; Mkyong.com 2015</p>
	</footer>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/lib/jquery/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/core/js/core.js" var="coreJs" />
<spring:url value="/resources/core/lib/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${jqueryJs}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


