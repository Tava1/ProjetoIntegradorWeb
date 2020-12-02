<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Listar Categorias de Produtos</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-products">
    <h1>Manutenção de Categoria de produtos</h1>
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

          <c:forEach var="categoria" items="${listaCategorias}">
            <tr>
              <th scope="row">${categoria.categoriaID}</th>
              <td>${categoria.titulo}</td>
              <td>
                <a href="DetalheCategoria?categoriaID=${categoria.categoriaID}">
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
  <script src="./scripts/category.js"></script>
</body>

</html>