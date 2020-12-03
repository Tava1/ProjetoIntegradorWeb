$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $.ajax({
    type: 'GET',
    url: '/Dragsters/BuscarCategorias',
    success: function (data) {
      let optionsCategorias = '<option value="0">Selecione o Categoria</option>';

      for (let key of data) {
        optionsCategorias += `<option value="${key.categoriaID}">${key.titulo}</option>`
      }

      $('#relatorio-categoria').html(optionsCategorias);
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })

  $.ajax({
    type: 'GET',
    url: '/Dragsters/BuscarUnidades',
    success: function (data) {
      let optionsUnidade = '<option id="0" value="0">Selecione a Unidade</option>';

      for (let key of data) {
        optionsUnidade += `<option value="${key.unidadeID}">${key.endereco}</option>`
      }

      $('#relatorio-unidade').html(optionsUnidade);
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })

});

