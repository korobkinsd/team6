<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../layouts/header.jsp" />
<spring:url value="/interviews/add" var="urlAddInterview" />
<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Interviews</h1>

    <div class="navbar-header">
        <a class="navbar-brand" href="${urlAddInterview}">Add Interview</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th><a href="?columnName=id&order=${order}&page=${pageNumber}">ID</a></th>
            <th><a href="?columnName=idVacancy&order=${order}&page=${pageNumber}">IDVacancy</a></th>
            <th><a href="?columnName=idCandidate&order=${order}&page=${pageNumber}">IDCandidate</a></th>
            <th><a href="?columnName=planDate&order=${order}&page=${pageNumber}">PlanDate</a></th>
            <th><a href="?columnName=factDate&order=${order}&page=${pageNumber}">FactDate</a></th>
            <th>Action</th>
        </tr>

        <form:form class="form-horizontal" method="get" modelAttribute="interviewForm" action="${interviewActionUrl}">
            <tr>
                <th><spring:bind path="id">
                    <div class="col-sm-10">
                        <form:input path="id" type="text" class="form-control " id="id"
                                    placeholder="id"/>
                    </div>
                </spring:bind>
                </th>

                <th><spring:bind path="idVacancy">
                    <div class="col-sm-10">
                        <form:input path="idVacancy" type="text" class="form-control " id="idVacancy"
                                    placeholder="idVacancy"/>
                    </div>
                </spring:bind>
                </th>

                <th><spring:bind path="idCandidate">

                    <div class="col-sm-10">
                        <form:input path="idCandidate" type="text" class="form-control " id="idCandidate"
                                    placeholder="idCandidate"/>
                    </div>
                </spring:bind>
                </th>
                <th><spring:bind path="planDate">

                    <div class="col-sm-10">
                        <form:input path="planDate" type="date" class="form-control " id="planDate"
                                    placeholder="planDate"/>
                    </div>
                </spring:bind>
                </th>

                <th><spring:bind path="factDate">

                    <div class="col-sm-10">
                        <form:input path="factDate" type="date" class="form-control " id="factDate"
                                    placeholder="factDate"/>
                    </div>
                </spring:bind>
                </th>
                <th>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn-lg btn-primary pull-right">Apply filtering</button>
                        </div>
                    </div>
                </th>
            </tr>
        </form:form>
        </thead>

        <c:forEach var="interview" items="${interviews}">
            <tr>
                <td>${interview.id}</td>
                <td>${interview.idVacancy}</td>
                <td>${interview.idCandidate}</td>
                <td>${interview.planDate}</td>
                <td>${interview.factDate}</td>
                <td>
                    <spring:url value="/interviews/${interview.id}" var="interviewUrl" />
                    <spring:url value="/interviews/${interview.id}/delete" var="deleteUrl" />
                    <spring:url value="/interviews/${interview.id}/update" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${interviewUrl}'">Show</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../layouts/footer.jsp" />

</body>
</html>



