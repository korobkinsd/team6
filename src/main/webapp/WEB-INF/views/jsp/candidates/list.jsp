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

				<c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if>
				<h1><spring:message code="label.table.title.candidates"/></h1>
					<div id="navbar">
						<ul class="nav navbar-nav navbar-right">
							<spring:url value="/candidates/add" var="urlAddCandidate" />
							<li class="active"><a href="${urlAddCandidate}"><spring:message code="button.add"/></a></li>
						</ul>
					</div>
					<div class="table-responsive">
						<table class="table table-striped">
						<thead>
							<tr>
								<th><a href="?columnName=id&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.candidate_id"/></th>
								<th><a href="?columnName=name&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.candidate_name"/></th>
								<th><a href="?columnName=surname&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.candidate_surname"/></th>
								<th><a href="?columnName=salary&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.candidate_salary"/></th>
								<th><a href="?columnName=birthday&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.candidate_birthday"/></th>
								<th><a href="?columnName=candidateState&order=${order}&page=${pageNumber}"><spring:message code="label.table.column.candidate_state"/></th>
								<th><spring:message code="label.table.column.action"/></th>
							</tr>
							<spring:url value="/candidates" var="candidatesApplyFilterUrl" />
                            <form:form class="form-horizontal" method="get" modelAttribute="candidatesFilter" action="${candidatesApplyFilterUrl}">
                                <tr>
                                    <th><spring:bind path="id">

                                        <div class="col-sm-10">
                                            <form:input path="id" type="text" class="form-control " id="id"
                                                        placeholder="id"/>
                                        </div>
                                    </spring:bind>
                                    </th>

                                    <th><spring:bind path="name">

                                        <div class="col-sm-10">
                                            <form:input path="name" type="text" class="form-control " id="name"
                                                        placeholder="name"/>
                                        </div>
                                    </spring:bind>
                                    </th>

                                    <th><spring:bind path="surname">

                                        <div class="col-sm-10">
                                            <form:input path="surname" type="text" class="form-control " id="surname"
                                                        placeholder="surname"/>
                                        </div>
                                    </spring:bind>
                                    </th>

                                    <th><spring:bind path="salary">

                                        <div class="col-sm-10">
                                            <form:input path="salary" type="text" class="form-control " id="salary"
                                                        placeholder="salary"/>
                                        </div>
                                    </spring:bind>
                                    </th>

                                    <th><spring:bind path="birthday">

                                        <div class="col-sm-10">
                                            <form:input path="birthday" type="text" class="form-control " id="birthday"
                                                        placeholder="birthday"/>
                                        </div>
                                    </spring:bind>
                                    </th>

                                    <th><spring:bind path="candidateState">
                                        <div class="col-sm-10">
                                            <form:select path="candidateState" class="form-control" id="candidateState">
                                                <option value="">Empty</option>
                                                <c:forEach items="${listCandidateState}" var="listOfStates">
                                                    <option   ${listOfStates == candidateForm.candidateState ? 'selected' : ''} value="${listOfStates}">${listOfStates.description}</option>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </spring:bind>
                                    </th>

                                    <th>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn-lg btn-primary pull-right">Apply</button>
                                            </div>
                                        </div>
                                    </th>

                                </tr>
                            </form:form>

						</thead>

						<c:forEach var="candidate" items="${candidates}">
							<tr>
								<td>${candidate.id}</td>
								<td>${candidate.name}</td>
								<td>${candidate.surname}</td>
								<td>${candidate.salary}</td>
								<td>${candidate.birthdayAsString}</td>
								<td>${candidate.candidateState.description}</td>
								<td>
									<spring:url value="/candidates/${candidate.id}" var="showUrl" />
									<spring:url value="/candidates/${candidate.id}/delete" var="deleteUrl" />
									<spring:url value="/candidates/${candidate.id}/update" var="updateUrl" />

									<button class="btn-sm btn-info" onclick="location.href='${showUrl}'">Show</button>
									<button class="btn-sm btn-primary" onclick="location.href='${updateUrl}'"><spring:message code="button.update"/></button>
									<button class="btn-sm btn-danger" onclick="this.disabled=true;post('${deleteUrl}')"><spring:message code="button.delete"/></button></td>
							</tr>
						</c:forEach>
						</table>
					</div>

				</main>
			</div>


	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>