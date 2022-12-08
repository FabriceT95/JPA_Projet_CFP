<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

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

        .login__container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            height: 100%;
        }

        .login__form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 1.5em;
        }

        .login__input {
            margin: 1em 0;
        }

        .login__header {
            text-align: center;
        }

    </style>
</head>
<body>

<main>
    <div class="login__container">

        <h1 class="login__header">Welcome on the InVoiCe MaNaGer</h1>

        <c:if test="${loginFail}">
            <div class="alert alert-danger" role="alert">Bad credentials</div>
        </c:if>

        <form class="login__form" method="post" action="${pageContext.request.contextPath}/login">
            <div class="login__input">
                <input placeholder="Username" type="text" name="username">
            </div>

            <div class="login__input">
                <input placeholder="Password" type="password" name="password">
            </div>
            <div style="background: #2A303D; border-radius: 8px;">
                <button style="width:100%; padding: 1em; border: none; background: none; line-height: 18px; font-weight: 700; color: white; font-size: 16px;" type="submit">Login</button>
            </div>
        </form>
    </div>
</main>


</body>
</html>