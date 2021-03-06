<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css" />
  <title>Alteração de Unidade</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-create-employee">
    <h2>Alteração de Unidade</h2>
    <p>Cadastro de cliente realizado pela filiar, ainda não sei o que colocar aqui</p>
    <div class="creation-data">
      <form action="" method="post">
        <input type="number" placeholder="ID" id="unidade-id" value="${unidade.unidadeID}" disabled>
        <select id="unidade-titulo">
          <option value="0">Selecione o titulo da unidade</option>
          <option value="Filial">Filial</option>
          <option value="Matriz">Matriz</option>
        </select>
        <input type="numeber" name="cep" id="cep" placeholder="CEP">
        <input type="text" name="rua" id="unidade-endereco" value="${unidade.endereco}" placeholder="Endereço">
        <input type="number" id="unidade-endereco-numero" value="${unidade.enderecoNumero}" placeholder="Nº">
        <input type="text" name="uf" id="unidade-estado" value="${unidade.estado}" placeholder="Estado" disabled>
        <input type="text" name="cidade" id="unidade-cidade" value="${unidade.cidade}" placeholder="Cidade" disabled>

        <button id="update-branch" class="button-create">Salvar</button>
      </form>
    </div>
  </div>

  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/branch.js"></script>
  <script src="./scripts/apis/api-cep.js"></script>
</body>

</html>