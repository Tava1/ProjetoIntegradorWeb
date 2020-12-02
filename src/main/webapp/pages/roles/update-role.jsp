<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Atulizar cargo</title>
</head>

<body>
  <%@include file="../../header.jsp" %>


  <div id="page-create-role">
    <h1>Atulizar Cargo</h1>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur laboriosam aliquam earum inventore vel
      repellendus, suscipit cupiditate consectetur repudiandae consequatur ipsam ullam! Architecto ratione velit ad
      quidem quis esse! Ad!</p>
    <div class="creation-data">
      <form method="post" action="">
        <div class="creation-data-inputs">
          <!-- Input de ID sempre deve conter a propriedade disabled -->
          <input id="role-id" name="input-id" type="number" placeholder="ID" value="${cargo.cargoID}" disabled>

          <input id="role-titulo" name="input-titulo" value="${cargo.titulo}" type="text" placeholder="Titulo">
        </div>
        <button id="update-role" class="button-create">Salvar</button>
      </form>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/6d228377c9.js" crossorigin="anonymous"></script>
  <script src="./lib/jquery-3.5.1.js"></script>
  <script src="./scripts/roles.js"></script>
</body>

</html>