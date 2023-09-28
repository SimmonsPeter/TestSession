<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Afficher Panier</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
    <jsp:include page="navbar.jsp"/>
</header>
<div class="container mt-5">
    <h1>Contenu du Panier</h1>

    <c:choose>
        <c:when test="${not empty panier.liste}">
            <!-- Table for displaying items -->
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Titre</th>
                    <th>Crédits</th>
                    <th>Session</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cours" items="${panier.liste}">
                    <tr>
                        <td>${cours.id}</td>
                        <td>${cours.title}</td>
                        <td>${cours.nbrCredits}</td>
                        <td>${cours.session}</td>
                        <td><a href="${pageContext.request.contextPath}/inscription/supprimer?id=${cours.id}" class="btn btn-danger">Supprimer</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/inscription/valider" class="btn btn-success">Valider mes choix</a>
        </c:when>
        <c:otherwise>
            <!-- Message when the list is empty -->
            <div class="alert alert-warning">
                Vous n'avez pas choisi de cours.
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
