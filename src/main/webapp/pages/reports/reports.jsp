<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/global.css">
  <title>Reports</title>
</head>

<body>
  <%@include file="../../header.jsp" %>

  <h2>Manutenção de produto</h2>
  <div class="midle-square">
    <input type="text" id="nome-cliente">
    <select>
      <option value="nome-select">Nome Cliente</option>
    </select>
    <select>
      <option value="categoria-select">Categoria</option>
    </select>
    <button id="Buscar">Buscar</button>
  </div>
  <div>
    <div class="table-square">

    </div>
  </div>
</body>

</html>