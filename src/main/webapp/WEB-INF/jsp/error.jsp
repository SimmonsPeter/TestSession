<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        div {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;

        }

        img {
            max-width: 100%; /* ensures image doesn't overflow its container */
        }
    </style>
</head>
<body>
<h1>Attention, une erreur s’est produite dans la ressource demandée. Veuillez contacter le support technique. </h1>
<h2>Message : ${message}</h2>
<h2>Date :${timestamp}</h2>
<h2>Code : ${status}</h2>
<c:url var="accueilURL" value="/accueil"/>
<hr/> <a href="${accueilURL}"> allez à l'accueil</a>
<div><img src="${pageContext.request.contextPath}/images/404-error-page-examples-best.png" alt="404"></div>
</body>
</html>
