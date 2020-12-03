<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css" />
  <title>Login</title>
</head>

<body>
  <div id="page-login">
    <div class="wrapper-login">
      <h1>DRAGSTERS</h1>
      <form method="POST" action="LoginController">
        <input name="login" type="number" placeholder="Nome" required>
        <input name="senha" type="password" placeholder="Senha" required>
        <c:if test="${not empty param.erro}">
          <div>
            Usuário ou senha inválidos!
          </div>
        </c:if>

        <button type="submit">Entrar</button>
      </form>
    </div>
  </div>
</body>

</html>