<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Listar Produtos</title>
</head>

<body>
  <header id="topbar">
    <div class="wrapper">
      <div class="logo">
        <h1>DRAGSTERS</h1>
      </div>

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


  <div id="page-order">
    <!-- Buscar o cliente pelo CPF -->
    <form action="" method="get">
      <div class="">
        <input id="customer-cpf" type="number" placeholder="CPF" required>
        <input id="customer-name" type="text" placeholder="Nome" value="" disabled>
      </div>
      <button id="get-customer" class="button-search">Buscar</button>
    </form>

    <!-- Buscar os produtos pelo CPF -->
    <form action="" method="get">
      <input id="product-id" type="number" placeholder="Código">
      <button id="get-product" class="button-search">Buscar</button>
    </form>

    <div class="result-table">
      <table>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Marca</th>
            <th scope="col">Modelo</th>
            <th scope="col">Descrição</th>
            <th scope="col">Preço UN</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr id="order-product-result"></tr>
        </tbody>
      </table>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/order.js"></script>
</body>

</html>