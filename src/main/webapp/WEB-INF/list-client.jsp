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
    <style>
        .styled-table {
            border-collapse: collapse;
            margin: 25px auto;
            font-size: 0.9em;
            font-family: sans-serif;
            min-width: 400px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }

        .styled-table thead tr {
            background-color: #2A303D;
            color: #ffffff;
            text-align: left;
        }

        .styled-table th,
        .styled-table td {
            padding: 12px 15px;
        }

        .styled-table tbody tr {
            border-bottom: 1px solid #dddddd;
        }

        .styled-table tbody tr:nth-of-type(even) {
            background-color: #f3f3f3;
        }

        .styled-table tbody tr:last-of-type {
            border-bottom: 2px solid #009879;
        }

        .styled-table tbody tr.active-row {
            font-weight: bold;
            color: #009879;
        }

        .listClient__addButton {
            background-color: #2A303D;
            color: white;
            padding: 1em;
            border: none;
            line-height: 18px;
            font-weight: 700;
            font-size: 16px;
            margin: auto;
        }

        a {
            color: white;
            text-decoration: none;
        }

        .listClient__content {
            margin-top: 2em;
            display: flex;
            flex-direction: column;
        }


    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<main>

    <div class="listClient__content">
        <div class="listClient__addButton">
            <a href="${pageContext.request.contextPath}/app/clients/add">Ajouter un nouveau client</a>
        </div>


        <table class="styled-table">
            <thead>
            <tr>
                <th>Client Id</th>
                <th>Client Name</th>
                <th>Client Address</th>
                <th>Client City</th>
                <th>Client Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="client" items="${clientList}">
                <tr>
                    <td><c:out value="${client.idClient}"/></td>
                    <td><c:out value="${client.name}"/></td>
                    <td><c:out value="${client.address}"/></td>
                    <td><c:out value="${client.city}"/></td>
                    <td><c:out value="${client.email}"/></td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/app/clients/delete">
                            <input name="idClientDelete" type="hidden" value="${client.idClient}"/>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</main>

</body>
</html>
