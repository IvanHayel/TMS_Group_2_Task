<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constant.CalculatorWebConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="pathAuthorization" value="${CalculatorWebConstants.PATH_AUTHORIZATION}"/>
<html>
<head>
    <title>Unauthorized</title>
    <jsp:include page="../common/_head.jsp"/>
</head>
<body>
<jsp:include page="../common/_header.jsp"/>
<div class="d-flex flex-row align-items-center" style="min-height: 100vh;">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-12 text-center">
                <span class="display-1 d-block">401</span>
                <div class="mb-4 lead">Access is denied due to invalid credentials!</div>
                <a href="${pathAuthorization}" class="btn btn-link link-success">TRY AGAIN</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/_footer.jsp"/>
</body>
</html>
