<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>


        .registerClient__form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 1.5em;
        }

        .registerClient__form > label {
            position: absolute;
            top: 0;
            display: block;
            transition: 0.2s;
            font-size: 1rem;
            color: red;
        }

        .registerClient__form > input:focus {
            padding-bottom: 6px;
            font-weight: 700;
            border-width: 3px;
            border-image: linear-gradient(to right, #11998e, #38ef7d);
            border-image-slice: 1;
        }

        .registerClient__form > input:focus ~ label {
            position: absolute;
            top: 0;
            display: block;
            transition: 0.2s;
            font-size: 1rem;
            color: #11998e;
            font-weight: 700;
        }

        input {
            font-family: inherit;
            width: 100%;
            border: 0;
            border-bottom: 2px solid #9b9b9b;
            outline: 0;
            font-size: 1.3rem;
            color: white;
            padding: 7px 0;
            background: transparent;
            transition: border-color 0.2s;
        }

        input:placeholder-shown ~ label {
            font-size: 1.3rem;
            cursor: text;
            top: 20px;
        }


        input::placeholder {
            color: transparent;
        }

        .registerClient__formGroup {
            position: relative;
            padding: 15px 0 0;
            margin-top: 10px;
            width: 50%;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form class="registerClient__form" method="post" action="${pageContext.request.contextPath}/app/clients/add">
    <input id="clientId" name="clientId" type="hidden" value="${clientId}"/>
    <div class="registerClient__formGroup">
        <label for="clientName">Name:</label>
        <input id="clientName" name="clientName" type="text" value="${clientName}"/>
    </div>
    <div class="registerClient__formGroup">
        <label for="clientEmail">Email:</label>
        <input id="clientEmail" name="clientEmail" type="text" value="${clientEmail}"/>

    </div>
    <div class="registerClient__formGroup">
        <label for="clientAddress">Address:</label>
        <input id="clientAddress" name="clientAddress" type="text" value="${clientAddress}"/>
    </div>

    <div class="registerClient__formGroup">
        <label for="clientCity">City:</label>
        <input id="clientCity" name="clientCity" type="text" value="${clientCity}"/>
    </div>

    <div class="registerClient__formGroup">
        <label for="clientPhoneNumber">Phone Number:</label>
        <input id="clientPhoneNumber" name="clientPhoneNumber" type="text" value="${clientPhoneNumber}"/>
    </div>

    <div class="registerClient__formGroup">
        <label for="clientPostalCode">Postal Code:</label>
        <input id="clientPostalCode" name="clientPostalCode" type="text" value="${clientPostalCode}"/>
    </div>

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
