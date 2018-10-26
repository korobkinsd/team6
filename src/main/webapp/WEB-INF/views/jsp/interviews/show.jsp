<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

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

    <h1>Interview Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${interview.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">ID Vacancy</label>
        <div class="col-sm-10">${interview.idVacancy}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Plan Date</label>
        <div class="col-sm-10">${interview.planDate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">ID Candidate</label>
        <div class="col-sm-10">${interview.idCandidate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Fact Date</label>
        <div class="col-sm-10">${interview.factDate}</div>
    </div>
</div>

<jsp:include page="../layouts/footer.jsp" />

</body>
</html>