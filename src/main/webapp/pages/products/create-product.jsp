<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Criar novo produto</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-create-employee">
    <h1>Novo produto</h1>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur laboriosam aliquam earum inventore vel
      repellendus, suscipit cupiditate consectetur repudiandae consequatur ipsam ullam! Architecto ratione velit ad
      quidem quis esse! Ad!</p>
    <div class="creation-data">
      <form method="post" action="">
        <div class="creation-data-inputs">
          <input class="input-60" id="produto-marca" type="text" placeholder="Marca">
          <input class="input-40" id="produto-modelo" type="text" placeholder="Modelo">
        </div>
        <div class="creation-data-inputs">
          <textarea class="input-100" name="" id="produto-descricao" cols="30" rows="10"
            placeholder="Descrição"></textarea>
        </div>

        <div class="creation-data-inputs">
          <input class="input-100" id="produto-preco" type="text" placeholder="Preço P/ Unidade">
          <input class="input-100" id="produto-estoque-quantidade" type="number" placeholder="Quantidade de estoque">
        </div>

        <div class="creation-data-inputs">
          <select class="input-20" id="produto-categoria">
          </select>

          <select class="input-20" id="produto-unidade">
          </select>
        </div>

        <button id="create-product" class="button-create">Cadastrar</button>
      </form>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/apis/jquery.maskMoney.js" type="text/javascript"></script>
  <script src="./scripts/product.js"></script>
</body>

</html>