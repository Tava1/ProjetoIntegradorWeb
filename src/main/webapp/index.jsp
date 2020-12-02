<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Menu</title>
</head>

<body>
  <%@include file="./header.jsp" %>

  <div id="page-menu">
    <div class="menu-square">
      <div class="container-12">
        <a class="col-4" href="/Dragsters/ProdutoController">
          <div class="menu-item">
            <i class="fas fa-box-open"></i>
            <span>PRODUTO</span>
          </div>
        </a>
        <a class="col-4" href="/Dragsters/ClienteController">
          <div class="menu-item">
            <i class="fas fa-users"></i>
            <span>CLIENTE</span>
          </div>
        </a>
        <a class="col-4" href="/Dragsters/FuncionarioController">
          <div class="menu-item">
            <i class="fas fa-users-cog"></i>
            <span>FUNCIONARIO</span>
          </div>
        </a>
        <a class="col-4" href="/Dragsters/VendaController">
          <div class="menu-item">
            <i class="fas fa-cash-register"></i>
            <span>CAIXA</span>
          </div>
        </a>
        <a class="col-4" href="">
          <div class="menu-item">
            <i class="fas fa-clipboard"></i>
            <span>RELATORIO</span>
          </div>
        </a>
      </div>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
</body>

</html>