<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inscrição em Atividade</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/seuEstilo.css">
</head>
<body>
    <h1>Inscrição em Atividade</h1>
    <form action="inscrever" method="POST">

        <label for="nome">Nome:</label>
        <input type="text" name="nome" required><br>

        <label for="email">E-mail:</label>
        <input type="email" name="email" required><br>

        <label for="senha">E-mail:</label>
        <input type="password" name="senha" required><br>

        <input type="submit" value="Inscrever-se na Atividade">
    </form>
</body>
</html>
