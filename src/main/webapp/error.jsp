<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Erro!</title>
</head>

<body>
  <%@include file="./header.jsp" %>
  <h1>Erro!</h1>
  <br />
  <p>${erro}</p>
  <br />
  <a href="index.jsp">Voltar</a>
</body>

</html>