<%--
  Created by IntelliJ IDEA.
  User: Fabrice
  Date: 07/12/2022
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<jsp:include page="header.jsp"/>
<p>Id Facture :<c:out value="${facture.idFacture}"/></p>
<p>Date de création : <c:out value="${facture.createdAt}"/></p>
<p>Prix HT : <c:out value="${facture.priceHT}"/></p>
<p>Prix TTC : <c:out value="${facture.priceTTC}"/></p>
<p>Client :  <c:out value="${facture.client.name}"/> - <c:out value="${facture.client.address}"/> - <c:out value="${facture.client.postalCode}"/> - <c:out value="${facture.client.city}"/> - <c:out value="${facture.client.phoneNumber}"/> - <c:out value="${facture.client.email}"/></p>
<p>Produit :</p>

<c:forEach var="item" items="${facture.items}">
    <p><c:out value="${item.produit.idProduit}"/> - <c:out value="${item.produit.name}"/> - <c:out value="${item.produit.description}" /> - <c:out value="${item.produit.priceHT}" /> - <c:out value="${item.produit.percentageTVA}" /> - <c:out value="${item.quantity}" /></p>
</c:forEach>
</body>
</html>
