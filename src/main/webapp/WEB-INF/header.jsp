<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Tinos', serif;
    }

    body {
        height: 100vh;
        width: 100vw;
    }

    input {
        outline: 0;
        background: none;
        border-width: 0 0 1px;
        border-bottom-color: #E5E5E5;
        font-size: 16px;
        padding: 5px;
        color: #9D9D9D;
    }

    input::placeholder {
        color: #9D9D9D;
    }

    .header {
        background-color: #2A303D;
    }

    .header__content {
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        align-items: center;
        padding: 1em;
    }

    .header__item > a {
        color:white;
        text-decoration: none;

    }

    .header__logout {

        position: absolute;
        right:0;
    }

    .header__logoutButton {
        background-color: red;
        color: white;
        padding: 1em;
        border: none;
        line-height: 18px;
        font-weight: 700;
        font-size: 16px;
    }

</style>

<header class="header">
    <div class="header__content">
        <div class="header__item">
            <a href="${pageContext.request.contextPath}/app/clients">Liste des clients</a>
        </div>
        <div class="header__item">
            <a href="${pageContext.request.contextPath}/app/factures">Liste des factures</a>
        </div>
        <div class="header__logout">
            <form method="post" action="${pageContext.request.contextPath}/logout">
                <button class="header__logoutButton" type="submit" value="Logout">Logout</button>
            </form>
        </div>
    </div>


    <%--  <c:choose>--%>
    <%--    <c:when test="${not empty sessionScope.username}">--%>
    <%--      <a href="${pageContext.request.contextPath}/logout">Logout</a>--%>
    <%--    </c:when>--%>
    <%--    <c:otherwise>--%>
    <%--      <form method="post" action="${pageContext.request.contextPath}/logout">--%>
    <%--        <input type="submit" value="Logout"/>--%>
    <%--      </form>--%>
    <%--    </c:otherwise>--%>
    <%--  </c:choose>--%>
</header>
