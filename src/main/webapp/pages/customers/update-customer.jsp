<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css" />
  <title>Alteração de Cliente</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <div id="page-create-employee">
    <h2>Alteração de Cliente</h2>
    <p>Cadastro de cliente realizado pela filiar, ainda não sei o que colocar aqui</p>
    <div class="creation-data">
      <form action="" method="post">
        <input type="number" placeholder="ID" value="${cliente.clienteID}" id="cliente-id" disabled>
        <input type="text" id="cliente-nome" value="${cliente.nome}" placeholder="Nome">
        <input type="number" id="cliente-cpf" value="${cliente.CPF}" placeholder="CPF">

        <select id="cliente-genero">
          <option value="NA">Selecione o gênero</option>
          <option value="F">Feminino</option>
          <option value="M">Masculino</option>
          <option value="O">Prefiro não dizer</option>
        </select>
        <select id="cliente-estado-civil">
          <option value="0">Selecione o Estado Civíl</option>
          <option value="1">Solteiro(a)</option>
          <option value="2">Casado(a)</option>
          <option value="3">Divorciado(a)</option>
          <option value="4">Viúvo(a)</option>
          <option value="5">Separado(a)</option>
        </select>

        <input type="email" value="${cliente.email}" id="cliente-email" placeholder="E-mail">
        <input type="date" value="${cliente.dataNascimento}" id="cliente-data-nascimento">
        <input type="number" value="${cliente.numeroContato}" id="cliente-numero-contato"
          placeholder="Contato: (00) 0 0000 0000">
        <input type="numeber" name="cep" id="cep" placeholder="CEP">
        <input type="text" name="rua" value="${cliente.endereco}" id="cliente-endereco" placeholder="Endereço">
        <input type="number" id="cliente-endereco-numero" value="${cliente.enderecoNumero}" placeholder="Nº">
        <input type="text" id="cliente-complemento" value="${cliente.complemento}" placeholder="Complemento">

        <!-- <select id="cliente-cliente">
          <option value="">Cidade</option>
        </select> -->
        <input type="text" name="uf" id="cliente-estado" value="${cliente.estado}" placeholder="Estado" disabled>
        <input type="text" name="cidade" id="cliente-cidade" value="${cliente.cidade}" placeholder="Cidade" disabled>

        <!-- <select id="cliente-estado">
          <option value="">Estado</option>
        </select> -->

        <button id="update-customer" class="button-create">Salvar</button>
      </form>
    </div>
  </div>

  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/customer.js"></script>
  <script src="./scripts/apis/api-cep.js"></script>
</body>

</html>