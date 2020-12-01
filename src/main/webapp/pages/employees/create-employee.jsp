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


  <div id="page-create-employee">
    <h1>Novo Funcionário</h1>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur laboriosam aliquam earum inventore vel
      repellendus, suscipit cupiditate consectetur repudiandae consequatur ipsam ullam! Architecto ratione velit ad
      quidem quis esse! Ad!</p>
    <div class="creation-data">
      <form method="post" action="">
        <div class="creation-data-inputs">
          <input class="input-60" id="funcionario-nome" type="text" placeholder="Nome">
          <input class="input-40" id="funcionario-cpf" maxlength="11" type="number" placeholder="CPF">
        </div>

        <div class="creation-data-inputs">
          <input class="input-100" id="funcionario-email" type="email" placeholder="E-mail">
        </div>
        <div class="creation-data-inputs">
          <select class="input-20" id="funcionario-genero">
            <option value="NA">Selecione o gênero</option>
            <option value="F">Feminino</option>
            <option value="M">Masculino</option>
            <option value="O">Prefiro não dizer</option>
          </select>

          <input class="input-20" id="funcionario-data-nascimento" type="date" placeholder="Data de Nascimento">
        </div>

        <div class="creation-data-inputs">
          <label>Escolha uma senha de acesso ao sistema</label>
          <input class="input-20" id="funcionario-senha" type="password" placeholder="Senha">
        </div>

        <div class="creation-data-inputs">
          <select class="input-20" id="funcionario-cargo">
          </select>

          <select class="input-20" id="funcionario-unidade">
          </select>
        </div>

        <button id="create-employee" class="button-create">Cadastrar</button>
      </form>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/employee.js"></script>
</body>

</html>