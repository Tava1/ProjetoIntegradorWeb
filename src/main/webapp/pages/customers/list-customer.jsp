<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">

  <title>Listar Clientes</title>
</head>

<body>
  <header id="topbar">
    <div class="wrapper">
      <a href="/Dragsters/">
        <div class="logo">
          <h1>DRAGSTERS</h1>
        </div>
      </a>

      <div class="user-logged">

        <div class="user-information">
          <strong>Gustavo S.</strong>
          <span>São Paulo - SP</span>
        </div>
        <div class="user-avatar">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR7S9pKMslch4WjEcuH1FTueBDvu3nL4NTsNg&usqp=CAU"
            alt="avatar">
        </div>
      </div>
  </header>


  <div id="page-products">
    <h1>Manutenção de clientes</h1>
    <div class="filter">
      <form>
        <div class="filter-inputs">
          <input type="number" placeholder="ID" disabled>
          <input type="number" placeholder="CPF">
          <input type="text" placeholder="Nome">
        </div>
        <button class="button-search">Buscar</button>
      </form>
    </div>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">Nome</th>
            <th scope="col">CPF</th>
            <th scope="col">Data de Nascimento</th>
            <th scope="col">Cidade</th>
            <th scope="col">UF</th>
            <th scope="col">Alterar</th>
            <th scope="col">Deletar</th>

          </tr>
        </thead>

        <tbody>

          <c:forEach var="cliente" items="${listaClientes}">

            <tr>
              <td>${cliente.nome}</td>
              <td>${cliente.CPF}</td>
              <td>${cliente.dataNascimento}</td>
              <td>${cliente.cidade}</td>
              <td>${cliente.estado}</td>
              <td>
                <i class="fas fa-edit"></i>
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