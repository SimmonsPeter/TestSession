<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/7/2023
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Navigation -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <a class="navbar-brand px-5" href="${pageContext.request.contextPath}/accueil">
        <!-- You can insert a logo here if you have one -->
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse display-5" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/accueil">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/cours/liste">Choix de cours</a>
            </li>
            <li class="nav-item">
                <!-- Assuming you have an administration page -->
                <a class="nav-link" href="${pageContext.request.contextPath}/administration">Administration</a>
            </li>
        </ul>
    </div>
</nav>

