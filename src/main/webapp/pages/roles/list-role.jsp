<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Listar Cargos</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-products">
    <h1>Manutenção de Cargos</h1>
    <div class="filter">
      <form>
        <div class="filter-inputs">
          <input type="number" placeholder="ID">
          <input type="text" placeholder="Título">
        </div>
        <button class="button-search">Buscar</button>
      </form>
    </div>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Título</th>
            <th scope="col">Alterar</th>
            <th scope="col">Deletar</th>
          </tr>
        </thead>

        <tbody>

          <c:forEach var="cargo" items="${listaCargos}">
            <tr>
              <th scope="row">${cargo.cargoID}</th>
              <td>${cargo.titulo}</td>
              <td>
                <a href="DetalheCargo?cargoID=${cargo.cargoID}">
                  <i class="fas fa-edit"></i>
                </a>
              </td>
              <td>
                <div class="column-delete">
                  <button onClick="deleteRole(this)" id="delete-role" value=${cargo.cargoID}>
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

    </div>
    <div class="create-new">
      <a class="button-new" href="CriarCargo">Novo</a>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/roles.js"></script>
</body>

</html>