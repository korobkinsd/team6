<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<jsp:include page="../layouts/header.jsp"/>

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

    <h1><spring:message code="label.table.title.vacancy"/>    </h1>
    <spring:url value="/vacancy/add" var="urlAddVacancy" />
    <li class="active"><a href="${urlAddVacancy}"><spring:message code="button.add"/></a></li>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>
                <a href="?columnName=ID&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.id"/></a>
            </th>
            <th>
                <a href="?columnName=position&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.position"/></a>
            </th>
            <th>
                <a href="?columnName=idDeveloper&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.IdDeveloper"/></a>
            </th>
            <th>
                <a href="?columnName=salaryFrom&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.salary_from"/></a>
            </th>
            <th>
                <a href="?columnName=salaryTo&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.salary_to"/></a>
            </th>
            <th>
                <a href="?columnName=experienceYearsRequire&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.ExperienceYearsRequire"/></a>
            </th>
            <th>
                <a href="?columnName=vacancyState&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.vacancy.state"/></a>
            </th>
        </tr>



        <form:form class="form-horizontal" method="get" modelAttribute="vacancyForm" action="${vacancyActionUrl}">
            <tr>
                <th><spring:bind path="id">
                    <form:input path="id" type="text" class="form-control " id="id"  placeholder=""/>
                </spring:bind></th>

                <th><spring:bind path="position">

                    <div class="col-sm-10">
                        <form:input path="position" type="text" class="form-control " id="position"
                                    placeholder="position"/>
                    </div>
                </spring:bind>
                </th>
                <th><spring:bind path="idDeveloper">


                    <div class="col-sm-10">
                        <form:select path="idDeveloper" class="form-control" id="idDeveloper">
                            <option value="0">Пусто</option>
                            <c:forEach items="${listOfUsers}" var="listOfUsers">
                                <option  ${listOfUsers.id == vacancyForm.idDeveloper ? 'selected' : ''}
                                        value="${listOfUsers.id}">${listOfUsers.name}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </spring:bind>
                </th>
                <th><spring:bind path="salaryFrom">


                    <div class="col-sm-10">
                        <form:input path="salaryFrom" class="form-control" id="salaryTo" placeholder="salaryFrom"/>

                    </div>

                </spring:bind>
                </th>
                <th><spring:bind path="salaryTo">
                    <div class="col-sm-10">
                        <form:input path="salaryTo" rows="5" class="form-control" id="salaryTo" placeholder="salaryTo"/>
                    </div>
                </spring:bind>
                </th>
                <th><spring:bind path="experienceYearsRequire">
                    <div class="col-sm-10">
                        <form:input path="experienceYearsRequire" rows="5" class="form-control"
                                    id="experienceYearsRequire" placeholder="experienceYearsRequire"/>

                    </div>
                </spring:bind>
                </th>
                <th><spring:bind path="state">


                    <div class="col-sm-10">
                        <form:select path="state" class="form-control" id="state">
                            <option value="">Пусто</option>
                            <c:forEach items="${vacancyState}" var="state">
                                <option  ${state.toString() == vacancyForm.state ? 'selected' : ''}
                                        value="${state.toString()}">${state.toString()}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </spring:bind>
                </th>
                </th>
                <th>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">

                            <button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="button.filter"/> </button>

                        </div>
                    </div>
                </th>
            </tr>
        </form:form>

        </thead>

        <c:forEach var="vacancy" items="${vacancy}">
            <tr>
                <td>
                        ${vacancy.id}
                </td>
                <td>${vacancy.position}</td>
                <td>${vacancy.idDeveloper}</td>
                <td>${vacancy.salaryFrom}</td>
                <td>${vacancy.salaryTo}</td>
                <td>${vacancy.experienceYearsRequire}</td>
                <td>${vacancy.state}</td>
                <td>
                    <spring:url value="/vacancy/${vacancy.id}" var="vacancyShowUrl"/>
                    <spring:url value="/vacancy/${vacancy.id}/delete" var="deleteUrl"/>
                    <spring:url value="/vacancy/${vacancy.id}/update" var="updateUrl"/>

                    <button class="btn btn-info" onclick="location.href='${vacancyShowUrl}'"><spring:message code="button.show"/></button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'"><spring:message code="button.update"/></button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')"><spring:message code="button.delete"/></button>
                </td>

            </tr>
        </c:forEach>
    </table>

</div>



</body>
<footer><jsp:include page="../layouts/footer.jsp" /></footer>
</html>