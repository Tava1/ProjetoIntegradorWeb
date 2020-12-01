<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css" />
  <title>Cadastro de Unidade</title>
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
        </div>-
      </div>
    </div>
  </header>

  <div id="page-create-employee">
    <h2>Nova Unidade</h2>
    <p>Cadastro de cliente realizado pela filiar, ainda não sei o que colocar aqui</p>
    <div class="creation-data">
      <form action="" method="post">
        <select id="unidade-titulo">
          <option value="0">Selecione o titulo da unidade</option>
          <option value="Filial">Filial</option>
          <option value="Matriz">Matriz</option>
        </select>
        <input type="numeber" name="cep" id="cep" placeholder="CEP">
        <input type="text" name="rua" id="unidade-endereco" placeholder="Endereço">
        <input type="number" id="unidade-endereco-numero" placeholder="Nº">
        <input type="text" name="uf" id="unidade-estado" placeholder="Estado" disabled>
        <input type="text" name="cidade" id="unidade-cidade" placeholder="Cidade" disabled>

        <button id="create-branch" class="button-create">Cadastrar</button>
      </form>
    </div>
  </div>

  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/branch.js"></script>
  <script src="./scripts/apis/api-cep.js"></script>
</body>

</html>