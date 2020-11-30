<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Criar novo funcionario</title>
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


  <div id="page-create-role">
    <h1>Novo Funcionário</h1>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur laboriosam aliquam earum inventore vel
      repellendus, suscipit cupiditate consectetur repudiandae consequatur ipsam ullam! Architecto ratione velit ad
      quidem quis esse! Ad!</p>
    <div class="creation-data">
      <form method="post" action="">
        <div class="creation-data-inputs">
          <input id="funcionario-nome" name="input-nome" type="text" placeholder="Nome">
        </div>
        <input id="funcionario-cpf" name="input-nome" type="number" placeholder="CPF">

        <select id="" name="">
          <option value="0">Selecione o gênero</option>
        </select>

        <input id="funcionario-email" name="input-nome" type="text" placeholder="E-mail">
        <input id="funcionario-dataNascimento" name="input-nome" type="date" placeholder="Data de Nascimento">
        <input id="funcionario-senha" name="input-nome" type="password" placeholder="Senha">

        <div>
          <p>Selecione o Status:</p>
          <div>
            <input id="status-ativo" type="radio" name="status" value="1" checked>
            <label for="status-ativo">Ativo</label>
          </div>
          <div>
            <input id="status-inativo" type="radio" name="status" value="0">
            <label for="status-inativo">Inativo</label>
          </div>
        </div>

        <select name="" id="funcionario-cargo-id">
          <option value="1">Selecione o Cargo</option>
          <c:forEach var="cargo" items="${listaCargos}">
            <option value=${cargo.cargoID}>${cargo.titulo}</option>
          </c:forEach>
        </select>

        <select name="" id="funcionario-unidade-id">
          <option id="" value="0">Selecione a Unidade</option>
          <c:forEach var="unidade" items="${listaUnidades}">
            <option value=${unidade.cargoID}>${unidade.cidade}</option>
          </c:forEach>
        </select>

        <button id="create-employee" class="button-create">Cadastrar</button>
      </form>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/employee.js"></script>
</body>

</html>