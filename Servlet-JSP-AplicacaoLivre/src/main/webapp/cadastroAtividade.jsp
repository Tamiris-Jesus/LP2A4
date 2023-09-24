<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Atividade</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/cadastrarAtividade.css">

</head>
<body>
    <h1>Cadastro de Atividade</h1>
    <form action="atividade" method="POST">
        <label for="descricao">Descrição:</label>
        <input type="text" name="descricao" required><br>

        <label for="dia">Data:</label>
        <input type="date" name="dia" required><br>

        <label for="hora">Hora:</label>
        <input type="time" name="hora" required><br>

        <input type="submit" value="Cadastrar Atividade">
    </form>
</body>
</html>
