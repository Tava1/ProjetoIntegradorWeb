<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">

  <title>Listar Unidades</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-products">
    <h1>Manutenção de Unidades</h1>
    <div class="filter">
      <form>
        <div class="filter-inputs">
          <input type="number" placeholder="ID">
          <input type="text" placeholder="Endereço">
        </div>
        <button class="button-search">Buscar</button>
      </form>
    </div>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">ID Unidade</th>
            <th scope="col">Titulo</th>
            <th scope="col">Endereço</th>
            <th scope="col">Nº</th>
            <th scope="col">Cidade</th>
            <th scope="col">UF</th>
            <th scope="col">Alterar</th>
            <th scope="col">Deletar</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach var="unidade" items="${listaUnidades}">
            <tr>
              <td>${unidade.unidadeID}</td>
              <td>${unidade.titulo}</td>
              <td>${unidade.endereco}</td>
              <td>${unidade.enderecoNumero}</td>
              <td>${unidade.cidade}</td>
              <td>${unidade.estado}</td>
              <td>
                <a href="DetalheUnidade?unidadeID=${unidade.unidadeID}">
                  <i class="fas fa-edit"></i>
                </a>
              </td>
              <td>
                <i class="fas fa-times"></i>
              </td>
            </tr>

          </c:forEach>

        </tbody>
      </table>

    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>

</body>


</html>