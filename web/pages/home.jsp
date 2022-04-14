<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Calculator</title>
    <jsp:include page="common/_head.jsp"/>
</head>
<body>
<jsp:include page="common/_header.jsp"/>
<div class="container position-absolute top-50 start-50 translate-middle">
    <p class="text-center fs-1 fw-bold">
        <c:if test="${sessionScope.user == null}">
            Welcome to CALCULATOR!
        </c:if>
        <c:if test="${sessionScope.user != null}">
            Glad to see you, ${sessionScope.user.name}
        </c:if>
    </p>
</div>
<jsp:include page="common/_footer.jsp"/>
</body>
</html>