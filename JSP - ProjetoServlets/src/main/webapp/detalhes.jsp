<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styleDetalhes.css">
    <title>Detalhes do Cliente</title>
</head>
<body>
    <h1>Detalhes do Cliente</h1>
    <c:if test="${cliente != null}">
        <p><strong>Nome:</strong> ${cliente.nome}</p>
        <p><strong>CPF:</strong> ${cliente.cpf}</p>
        <p><strong>Data de nascimento:</strong> ${cliente.dataNascimento}</p>
        <p><strong>Telefone:</strong> ${cliente.telefone}</p>
    </c:if>

    <div class="instrucoes">
        Para buscar um cliente, insira o CPF na URL da seguinte maneira: <br>
       <span class="url">http://localhost:8080/detalhes?cpf=numero_do_cpf</span>
     </div>



</body>
</html>
