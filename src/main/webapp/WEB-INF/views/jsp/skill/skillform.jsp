<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>


<jsp:include page="../layouts/header.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${skillForm['new']}">
            <h1>Add skill</h1>
        </c:when>
        <c:otherwise>
            <h1>Update skill</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/skill" var="skillActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="skillForm" action="${skillActionUrl}">

        <spring:bind path="skill">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">skill</label>
                <div class="col-sm-10">
                    <form:input path="skill" type="text" class="form-control " id="skill" placeholder="skill" />

                    <form:errors path="skill" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${skillForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../layouts/footer.jsp" />

</body>
</html>