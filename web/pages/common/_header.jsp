<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
    <c:set var="currentUser" scope="request" value="${sessionScope.get('user')}"/>
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Calculator</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <c:if test="${currentUser == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/registration">Registration</a>
                    </li>
                </c:if>
                <c:if test="${currentUser == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/authorization">Authorization</a>
                    </li>
                </c:if>
                <c:if test="${currentUser != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/calculation">Calculation</a>
                    </li>
                </c:if>
                <c:if test="${currentUser != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/history">History</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <ul class="nav justify-content-end">
            <c:if test="${currentUser != null}">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/logout"
                       style="color:gray">Logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</header>