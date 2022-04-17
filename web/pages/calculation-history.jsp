<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Calculation History</title>
    <jsp:include page="common/_head.jsp"/>
</head>
<body>
<jsp:include page="common/_header.jsp"/>
<table class="table table-striped table-bordered align-middle" style="table-layout: fixed">
    <caption></caption>
    <thead>
    <tr>
        <th scope="col" class="col-1 text-center">Operation ID</th>
        <th scope="col" class="col-1 text-center">First value</th>
        <th scope="col" class="col-1 text-center">Operand</th>
        <th scope="col" class="col-1 text-center">Second value</th>
        <th scope="col" class="col-1 text-center">Result</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="operation" items="${requestScope.operationHistory}">
        <tr>
            <th scope="row" class="text-center">${operation.id}</th>
            <td class="text-center">${operation.firstValue}</td>
            <td class="text-center">${operation.operand}</td>
            <td class="text-center">${operation.secondValue}</td>
            <td class="text-center">${operation.result}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="common/_footer.jsp"/>
</body>
</html>