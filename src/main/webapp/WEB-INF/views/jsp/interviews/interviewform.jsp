<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../layouts/header.jsp" />


<div class="container">

    <c:choose>
        <c:when test="${interviewForm['new']}">
            <h1>Add interview</h1>
        </c:when>
        <c:otherwise>
            <h1>Update interview</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/interviews" var="interviewActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="interviewForm" action="${interviewActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="idVacancy">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">idVacancy</label>
                <div class="col-sm-10">
                    <form:input path="idVacancy" type="text" class="form-control" id="idVacancy" placeholder="idVacancy" />
                    <form:errors path="idVacancy" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="idCandidate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">idCandidate</label>
                <div class="col-sm-10">
                    <form:input path="idCandidate" type="text" class="form-control" id="idCandidate" placeholder="idCandidate" />
                    <form:errors path="idCandidate" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="planDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">planDate</label>
                <div class="col-sm-10">
                    <form:input path="planDate" type="date" class="form-control" id="planDate" placeholder="planDate" />
                    <form:errors path="planDate" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="factDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">factDate</label>
                <div class="col-sm-10">
                    <form:input path="factDate" type="date" class="form-control" id="factDate" placeholder="factDate" />
                    <form:errors path="factDate" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${interviewForm['new']}">
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


</html>