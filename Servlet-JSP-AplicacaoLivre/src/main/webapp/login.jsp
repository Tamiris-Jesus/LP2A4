<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/login.css">
    <title>Login do Organizador</title>
</head>
<body>
    <h1>Login do Organizador</h1>
    <form action="login" method="POST">
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>

        <label for="senha">Senha:</label>
        <input type="password" name="senha" required><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>
