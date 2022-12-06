<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form method="post" action="${pageContext.request.contextPath}/app/clients/add">
  <input id="clientId"  name="clientId" type="hidden" value="${clientId}" />
  <label for="clientName" >Name:</label>
  <input id="clientName" name="clientName" type="text" value="${clientName}" />

  <label for="clientEmail" >Email:</label>
  <input id="clientEmail" name="clientEmail" type="text" value="${clientEmail}" />

  <label for="clientAddress" >Address:</label>
  <input id="clientAddress" name="clientAddress" type="text" value="${clientAddress}" />

  <label for="clientCity" >City:</label>
  <input id="clientCity" name="clientCity" type="text" value="${clientCity}" />

  <label for="clientPhoneNumber" >Phone Number:</label>
  <input id="clientPhoneNumber" name="clientPhoneNumber" type="text" value="${clientPhoneNumber}" />

  <label for="clientPostalCode" >Postal Code:</label>
  <input id="clientPostalCode" name="clientPostalCode" type="text" value="${clientPostalCode}" />



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
