<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h1>Confirmation</h1>

    <!-- Display confirmation message -->
    <c:choose>
        <c:when test="${not empty confirmationMessage}">
            <div class="alert alert-success">
                    ${confirmationMessage}
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger">
                    ${errorMessage}
            </div>
        </c:otherwise>
    </c:choose>

    <!-- Display courses from panier if available -->
    <c:if test="${not empty panier.liste}">
        <h3>Cours choisis</h3>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Crédits</th>
                <th>Session</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cours" items="${panier.liste}">
                <tr>
                    <td>${cours.id}</td>
                    <td>${cours.title}</td>
                    <td>${cours.nbrCredits}</td>
                    <td>${cours.session}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <a href="${pageContext.request.contextPath}/clearSession" class="btn btn-primary">Return à l'accueil</a>
</div>

</body>
</html>
