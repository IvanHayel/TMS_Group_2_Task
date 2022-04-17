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
<c:if test="${requestScope.operation != null}">
    <c:set var="operand" value="${requestScope.operation.operand}"/>
    <c:set var="firstValue" value="${requestScope.operation.firstValue}"/>
    <c:set var="secondValue" value="${requestScope.operation.secondValue}"/>
    <c:set var="result" value="${requestScope.operation.result}"/>
</c:if>
<form class="position-absolute top-50 start-50 translate-middle" method="post">
    <h1 class="h3 fw-normal">Calculation</h1>
    <div class="form-floating mt-3">
        <input type="number" step="any" class="form-control" value="${firstValue}" name="firstValue" id="floatingFirstValue"
               placeholder="First value" required>
        <label for="floatingFirstValue">First value</label>
    </div>
    <div class="form-floating mt-3">
        <input type="text" class="form-control" value="${operand}" name="operand" id="floatingOperand"
               placeholder="Operand" required>
        <label for="floatingOperand">Operand</label>
    </div>
    <div class="form-floating mt-3">
        <input type="number" step="any" class="form-control" value="${secondValue}" name="secondValue" id="floatingSecondValue"
               placeholder="Second value" required>
        <label for="floatingSecondValue">Second value</label>
    </div>
    <div class="form-floating mt-3">
        <input type="number" step="any" class="form-control" value="${result}" name="result" id="floatingResult"
               placeholder="Result" required disabled/>
        <label for="floatingResult">Result</label>
    </div>
    <button class="w-100 btn btn-lg btn-primary mt-5 btn-success" type="submit">CALCULATE</button>
</form>
<jsp:include page="common/_footer.jsp"/>
</body>
</html>