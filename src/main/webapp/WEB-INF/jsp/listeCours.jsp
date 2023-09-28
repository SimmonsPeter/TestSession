<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
    <title>List of Courses</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
<jsp:include page="navbar.jsp"/>
</header>
<div class="container mt-5">
    <h1 class="mb-4">List of Courses</h1>
    <!-- Display the number of courses selected -->
    <div class="alert alert-info">
        Nombres de cours choisis: <strong>${fn:length(panier.liste)}</strong>
    </div>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Crédits</th>
            <th>Session</th>
            <th>Details</th>
            <th>Choisir</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cours" items="${listeCours}">
            <tr>
                <td>${cours.id}</td>
                <td>${cours.title}</td>
                <td>${cours.nbrCredits}</td>
                <td>${cours.session}</td>
                <td><a href="${pageContext.request.contextPath}/images/detailsNumcours.pdf" target="_blank" class="btn btn-info">Detail</a></td>
                <td>
                    <c:choose>
                        <c:when test="${panier.liste.contains(cours)}">
                            <button class="btn btn-success" disabled>Choisir</button>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/cours/ajouter?id=${cours.id}" class="btn btn-success">Choisir</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/inscription/afficher" class="btn btn-primary">Voir mes choix</a>
    <a href="${pageContext.request.contextPath}/accueil" class="btn btn-secondary">Retour à l'accueil</a>

</div>

<!-- Optionally add Bootstrap JS (and its dependencies) if you need JS components -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
