<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/listarAtividades.css">
    <title>Lista de Atividades</title>
</head>
<body>
    <h1>Lista de Atividades</h1>
    <table border="1">
        <tr>
            <th>Descrição</th>
            <th>Data</th>
            <th>Hora</th>
            <th>Inscrição</th> <!-- Nova coluna para o botão de inscrição -->
        </tr>
        <c:forEach var="atividade" items="${atividades}">
            <tr>
                <td>${atividade.descricao}</td>
                <td>${atividade.dia}</td>
                <td>${atividade.hora}</td>
                <td>
                    <a href="inscrever?atividadeId=${atividade.id}">Inscrever-se</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="cadastroAtividade.jsp">Cadastrar Nova Atividade</a>
</body>
</html>
