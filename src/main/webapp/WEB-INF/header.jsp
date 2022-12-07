
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="${pageContext.request.contextPath}/logout">
  <button type="submit" value="Logout">Logout</button>
</form>

<header>
  <a href="${pageContext.request.contextPath}/app/clients">Liste des clients</a>
  <a href="${pageContext.request.contextPath}/app/factures">Liste des factures</a>

  <c:choose>
    <c:when test="${not empty sessionScope.username}">
      <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:when>
    <c:otherwise>
      <form method="post" action="${pageContext.request.contextPath}/logout">
        <input type="submit" value="Logout"/>
      </form>
    </c:otherwise>
  </c:choose>
</header>
