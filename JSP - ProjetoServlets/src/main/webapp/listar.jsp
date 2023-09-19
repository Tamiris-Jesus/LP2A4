<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styleListar.css">
    <title>Listagem de Clientes</title>
</head>
<body>
    <h1>Listagem de Clientes</h1>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>CPF</th>
            <th>Telefone</th>
        </tr>
        <c:forEach var="cliente" items="${clientes}">
            <tr>
                <td>${cliente.nome}</td>
                <td>${cliente.dataNascimento}</td>
                <td>${cliente.cpf}</td>
                <td>${cliente.telefone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
