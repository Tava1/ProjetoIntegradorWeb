<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Reports</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-products">

    <h2>Detalhe da venda</h2>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">Código Pedido</th>
            <th scope="col">Modelo</th>
            <th scope="col">Quantidade</th>
            <th scope="col">Preço Unitário</th>
            <th scope="col">Total</th>
            <th scope="col">Nome do Cliente</th>
            <th scope="col">CPF</th>
            <th scope="col">Nome do Funcionario</th>
            <th scope="col">Endereço</th>
            <th scope="col">Data do Pedido</th>

          </tr>
        </thead>

        <tbody>

          <c:forEach var="detalhe" items="${detalhePedido}">

            <tr>
              <td>${detalhe.pedidoID}</td>
              <td>${detalhe.modelo}</td>
              <td>${detalhe.quantidade}</td>
              <td>${detalhe.precoUnitario}</td>
              <td>${detalhe.total}</td>
              <td>${detalhe.nomeCliente}</td>
              <td>${detalhe.cpfCliente}</td>
              <td>${detalhe.nomeFuncionario}</td>
              <td>${detalhe.enderecoUnidade}, ${cliente.enderecoNumeroUnidade}</td>
              <td>${detalhe.dataPedido}</td>
            </tr>

          </c:forEach>

        </tbody>
      </table>

    </div>
    <div class="create-new">
      <a class="button-new" href="RelatorioController">Voltar</a>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/report.js"></script>
</body>

</html>