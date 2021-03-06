
$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $("#produto-preco").maskMoney({ prefix: 'R$ ', allowNegative: true, thousands: '.', decimal: ',', affixesStay: false });

  $.ajax({
    type: 'GET',
    url: '/Dragsters/BuscarCategorias',
    success: function (data) {
      let optionsCategorias = '<option value="0">Selecione o Categoria</option>';

      for (let key of data) {
        optionsCategorias += `<option value="${key.categoriaID}">${key.titulo}</option>`
      }

      $('#produto-categoria').html(optionsCategorias);
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

      $('#produto-unidade').html(optionsUnidade);
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })

  $('#create-product').click(function () {

    const marca = $('#produto-marca').val();
    const modelo = $('#produto-modelo').val();
    const descricao = $('#produto-descricao').val();
    let precoUnitario = $('#produto-preco').val();
    const categoriaID = $('#produto-categoria option:selected').val();
    const unidadeID = $('#produto-unidade option:selected').val();

    precoUnitario = precoUnitario.replace(",", ".");

    const parameters = `marca=${marca}&modelo=${modelo}&descricao=${descricao}&precoUnitario=${precoUnitario}&categoriaID=${categoriaID}&unidadeID=${unidadeID}`;

    console.log(parameters);

    $.ajax({
      type: 'POST',
      url: '/Dragsters/CriarProduto',
      data: parameters,
      success: function (responseText) {
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })

  $('#update-product').click(function () {

    const produtoID = $('#produto-id').val();
    const marca = $('#produto-marca').val();
    const modelo = $('#produto-modelo').val();
    const descricao = $('#produto-descricao').val();
    let precoUnitario = $('#produto-preco').val();
    const categoriaID = $('#produto-categoria option:selected').val();
    const unidadeID = $('#produto-unidade option:selected').val();

    precoUnitario = precoUnitario.replace(",", ".");

    const parameters = `produtoID=${produtoID}&marca=${marca}&modelo=${modelo}&descricao=${descricao}&precoUnitario=${precoUnitario}&categoriaID=${categoriaID}&unidadeID=${unidadeID}`;

    $.ajax({
      type: 'PUT',
      url: '/Dragsters/DetalheProduto' + "?" + parameters,
      // data: parameters,
      success: function (responseText) {
        console.log(responseText);
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })


});

function deleteProduct(btn) {

  let produtoID = $(btn).val();
  let parameters = 'produtoID=' + produtoID;

  $.ajax({
    type: 'POST',
    url: '/Dragsters/ProdutoController',
    data: parameters,
    success: function (responseText) {
      location.reload();
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })
}
