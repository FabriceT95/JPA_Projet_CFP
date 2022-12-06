<%--
  Created by IntelliJ IDEA.
  User: Fabrice
  Date: 06/12/2022
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<button><a href="${pageContext.request.contextPath}/app/factures/add">Ajouter une nouvelle facture</a></button>
<c:forEach var="facture" items="${factureList}">
    <div style="display:flex">
        <p> <c:out value="${facture.idFacture}"/> - <c:out value="${facture.createdAt}"/> - <c:out value="${facture.priceHT}"/> - <c:out value="${facture.priceTTC}"/> </p>
        <form method="post" action="${pageContext.request.contextPath}/app/factures/delete">
            <input name="idFactureDelete" type="hidden"  value="${facture.idFacture}" />
            <button type="submit">Delete</button>
        </form>

        <button><a href="${pageContext.request.contextPath}/facture/details?id=${facture.idFacture}">Détails</a></button>
            <%--        <button><a href="${pageContext.request.contextPath}/games/details?id=${game.id}" >Details</a></button>--%>
    </div>
</c:forEach>

</body>
</html>
