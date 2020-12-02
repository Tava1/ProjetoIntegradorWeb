<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Listar Produtos</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-products">
    <h1>Manutenção de produtos</h1>
    <div class="filter">
      <form>
        <div class="filter-inputs">
          <input type="number" placeholder="ID">
          <input type="text" placeholder="Nome">
          <select>
            <option value="0">Selecione a categoria -</option>
            <option>Suspensão</option>
          </select>
        </div>
        <button class="button-search">Buscar</button>
      </form>
    </div>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Marca</th>
            <th scope="col">Modelo</th>
            <th scope="col">Descrição</th>
            <th scope="col">Preço UN</th>
            <th scope="col">Categoria</th>
            <th scope="col">Quantide em estoque</th>
            <th scope="col">Alterar</th>
            <th scope="col">Deletar</th>
          </tr>
        </thead>

        <tbody>

          <c:forEach var="produto" items="${listaProdutos}">
            <tr>
              <th scope="row">${produto.produtoID}</th>
              <td>${produto.marca}</td>
              <td>${produto.modelo}</td>
              <td>${produto.descricao}</td>
              <td>${produto.precoUnitario}</td>
              <td>${produto.categoriaID}</td>
              <td>0</td>
              <td>
                <a href="DetalheProduto?produtoID=${produto.produtoID}">
                  <i class="fas fa-edit"></i>
                </a>
              </td>
              <td>
                <button onClick="deleteProduct(this)" id="delete-product" value=${produto.produtoID}>
                  <i class="fas fa-times"></i>
                </button>
              </td>
            </tr>

          </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/product.js"></script>
</body>

</html>