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
    <h1>ManutenÃ§Ã£o de produtos</h1>
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
            </tr>

          </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</body>

</html>