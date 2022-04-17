<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constant.CalculatorWebConstants" %>
<c:url var="pathHome" value="${CalculatorWebConstants.PATH_HOME}"/>
<c:url var="pathRegistration" value="${CalculatorWebConstants.PATH_REGISTRATION}"/>
<c:url var="pathAuthorization" value="${CalculatorWebConstants.PATH_AUTHORIZATION}"/>
<c:url var="pathLogout" value="${CalculatorWebConstants.PATH_LOGOUT}"/>
<c:url var="pathCalculation" value="${CalculatorWebConstants.PATH_CALCULATION}"/>
<c:url var="pathCalculationHistory" value="${CalculatorWebConstants.PATH_CALCULATION_HISTORY}"/>
<c:set var="currentUser" scope="request" value="${sessionScope.user}"/>
<header class="navbar navbar-expand-lg sticky-top navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pathHome}">Calculator</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pathHome}">Home</a>
                </li>
                <c:if test="${currentUser == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pathRegistration}">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pathAuthorization}">Authorization</a>
                    </li>
                </c:if>
                <c:if test="${currentUser != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pathCalculation}">Calculation</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pathCalculationHistory}">History</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <ul class="nav justify-content-end">
            <c:if test="${currentUser != null}">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="${pathLogout}" style="color:gray">Logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</header>