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

    <h2>Relatório de vendas</h2>
    <div class="filter">
      <form>
        <div class="filter-inputs">
          <input type="number" placeholder="CPF do Cliente">
          <!-- <select class="input-20" id="relatorio-categoria">
          </select> -->
          <select class="input-20" id="relatorio-unidade">
          </select>
        </div>
        <button class="button-search">Buscar</button>
      </form>
    </div>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">Código Pedido</th>
            <th scope="col">Nome do Cliente</th>
            <th scope="col">CPF</th>
            <th scope="col">Nome do Funcionario</th>
            <th scope="col">Endereço</th>
            <th scope="col">Data do Pedido</th>
            <th scope="col">Total</th>
            <th scope="col">Detalhe</th>

          </tr>
        </thead>

        <tbody>

          <c:forEach var="pedido" items="${pedidos}">

            <tr>
              <td>${pedido.pedidoID}</td>
              <td>${pedido.nomeCliente}</td>
              <td>${pedido.cpfCliente}</td>
              <td>${pedido.nomeFuncionario}</td>
              <td>${pedido.enderecoUnidade}, ${cliente.enderecoNumeroUnidade}</td>
              <td>${pedido.dataPedido}</td>
              <td>${pedido.total}</td>
              <td>
                <a href="DetalheRelatorio?pedidoID=${pedido.pedidoID}">
                  <i class="fas fa-chevron-circle-down"></i>
                </a>
              </td>
            </tr>

          </c:forEach>

        </tbody>
      </table>

    </div>

  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/report.js"></script>
</body>

</html>