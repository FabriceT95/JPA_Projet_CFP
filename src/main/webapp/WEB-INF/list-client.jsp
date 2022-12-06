<%--
  Created by IntelliJ IDEA.
  User: Fabrice
  Date: 30/11/2022
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>

<!-- controle, iterations, tests, variables -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<button><a href="${pageContext.request.contextPath}/app/clients/add">Ajouter un nouveau client</a></button>
<c:forEach var="client" items="${clientList}">
    <div style="display:flex">
        <p> <c:out value="${client.name}"/> - <c:out value="${client.address}"/> - <c:out value="${client.city}"/> - <c:out value="${client.email}"/> </p>
        <form method="post" action="${pageContext.request.contextPath}/app/clients/delete">
            <input name="idClientDelete" type="hidden"  value="${client.idClient}" />
            <button type="submit">Delete</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/games/add">
            <input name="idUpdate" type="hidden"  value="${client.idClient}" />
            <button type="submit">Update</button>
        </form>
<%--        <button><a href="${pageContext.request.contextPath}/games/details?id=${game.id}" >Details</a></button>--%>
    </div>
</c:forEach>
</body>
</html>
