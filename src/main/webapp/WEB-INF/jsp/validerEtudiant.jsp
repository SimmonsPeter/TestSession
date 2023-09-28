<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Valider Étudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
    <jsp:include page="navbar.jsp"/>
</header>
<div class="container mt-5">
    <h1>Valider Étudiant</h1>

    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>NAS</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Confirmer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="etudiant" items="${listeEtudiants}">
            <tr>
                <td>${etudiant.nas}</td>
                <td>${etudiant.nom}</td>
                <td>${etudiant.prenom}</td>
                <td><a href="${pageContext.request.contextPath}/inscription/confirmer?nas=${etudiant.nas}" class="btn btn-primary">Confirmer</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
