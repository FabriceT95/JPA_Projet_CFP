<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<a href="${pageContext.request.contextPath}/app/produits/add">Ajouter un nouveau produit</a>
<form method="post" action="${pageContext.request.contextPath}/app/factures/add">
  <input id="factureId"  name="factureId" type="hidden" value="${factureId}" />

  <label for="client-select">Choose a client :</label>

  <select name="client" id="client-select">
    <option value="">--Please choose an option--</option>
  <c:forEach var="client" items="${clientList}">
    <option value="${client.idClient}">${client.name}</option>
  </c:forEach>
  </select>

  <label for="produit-select">Choose a client :</label>
  <select name="produit" id="produit-select" multiple>
    <option value="">--Please choose an option--</option>
    <c:forEach var="produit" items="${produitList}">
      <option value="${produit.idProduit}">${produit.name}</option>
    </c:forEach>
  </select>



  <c:choose>
    <c:when test='${not empty clientId}'>
      <button type="submit">Update</button>
    </c:when>
    <c:otherwise>
      <button type="submit">Add</button>
    </c:otherwise>
  </c:choose>


</form>
</body>
</html>
