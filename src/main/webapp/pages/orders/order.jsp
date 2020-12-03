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
  <%@include file="../../header.jsp" %>

  <div id="page-order">

    <h2>Venda</h2>
    <span>Realizar venda de produtos</span>
    <form action="">
      <div class="container-order">
        <!-- Buscar Produtos -->
        <div class="search-products item-a">
          <div class="search-products-filter">
            <input id="product-id" type="text" placeholder="Buscar produtos">
            <button id="get-product">
              <i class="fas fa-search"></i>
            </button>
          </div>

          <div id="result-product-info"></div>
        </div>

        <!-- Mostar relação dos produtos no carrinho -->
        <div class="cart item-c">
          <h3>Carrinho</h3>
          <div id="cart-products-result" class="cart-result"></div>
        </div>

        <div class="item-b search-customer">
          <input id="customer-cpf" type="number" placeholder="CPF do cliente" required>
          <button id="get-customer">
            <i class="fas fa-search"></i>
          </button>
        </div>

        <div class="item-d order-details">
          <div class="order-details-customer">
            <h3 id="result-customer-nome"></h3>
            <span id="result-customer-cpf"></span>
            <span id="result-customer-endereco"></span>
            <span id="result-customer-complemento"></span>
            <span id="result-customer-cidade"></span>
          </div>
          <div class="order-details-cart">
            <h3>Orçamento</h3>
            <div class="order-details-cart-amount">
              <span>Total:</span>
              <span id="amount"></span>
            </div>
          </div>
        </div>
      </div>
      <div class="process-order">
        <button id="proceed-order" class="button-search">Finalizar</button>
      </div>
    </form>


  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/order.js"></script>
</body>

</html>