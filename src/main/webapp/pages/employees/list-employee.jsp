<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Listar Funcionarios</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-products">
    <h1>Manutenção de Funcionarios</h1>
    <div class="filter">
      <form>
        <div class="filter-inputs">
          <input type="number" placeholder="ID">
          <input type="text" placeholder="Nome">
        </div>
        <button class="button-search">Buscar</button>
      </form>
    </div>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">CPF</th>
            <th scope="col">Genero</th>
            <th scope="col">Email</th>
            <th scope="col">Data de Nascimento</th>
            <th scope="col">Cargo</th>
            <th scope="col">Unidade</th>
            <th scope="col">Ativo</th>
            <th scope="col">Alterar</th>
            <th scope="col">Deletar</th>
          </tr>
        </thead>

        <tbody>

          <c:forEach var="funcionario" items="${listaFuncionarios}">
            <tr>
              <th scope="row">${funcionario.funcionarioID}</th>
              <td>${funcionario.nome}</td>
              <td>${funcionario.CPF}</td>
              <td>${funcionario.genero}</td>
              <td>${funcionario.email}</td>
              <td>${funcionario.dataNascimento}</td>
              <td>${funcionario.cargoID}</td>
              <td>${funcionario.unidadeID}</td>
              <td>
                <c:choose>
                  <c:when test="${funcionario.ativo==1}">
                    <i class="fas fa-check-circle"></i>
                  </c:when>
                  <c:otherwise>
                    <i class="fas fa-times-circle"></i>
                  </c:otherwise>
                </c:choose>
              </td>
              <td>
                <a href="DetalheFuncionario?funcionarioID=${funcionario.funcionarioID}">
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
  <script src="./scripts/roles.js"></script>
</body>

</html>