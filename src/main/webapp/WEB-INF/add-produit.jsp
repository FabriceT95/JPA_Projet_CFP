<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form method="post" action="${pageContext.request.contextPath}/app/produits/add">
    <input id="produitId"  name="produitId" type="hidden" value="${produitId}" />
    <label for="produitName" >Name:</label>
    <input id="produitName" name="produitName" type="text" value="${produitName}" />

    <label for="produitDescription" >Description:</label>
    <input id="produitDescription" name="produitDescription" type="text" value="${produitDescription}" />

    <label for="produitPourcentageTVA" >TVA:</label>
    <input id="produitPourcentageTVA" name="produitPourcentageTVA" type="text" value="${produitPourcentageTVA}" />

    <label for="produitPriceHT" >Price HT:</label>
    <input id="produitPriceHT" name="produitPriceHT" type="text" value="${produitPriceHT}" />


    <c:choose>
        <c:when test='${not empty produitId}'>
            <button type="submit">Update</button>
        </c:when>
        <c:otherwise>
            <button type="submit">Add</button>
        </c:otherwise>
    </c:choose>


</form>
</body>
</html>
