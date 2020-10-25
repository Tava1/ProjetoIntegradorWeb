$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  // Consultar o CPF do cliente para associá-lo ao Pedido/Venda 
  $('#get-customer').click(function () {

    const customerCPF = $('#customer-cpf').val();

    // Parametros de rota
    const parameters = 'cpf=' + customerCPF;

    $.ajax({
      type: 'GET',
      url: '/Dragsters/ConsultarClienteCPF',
      data: parameters,
      success: function (responseText) {
        console.log(responseText);
        $('#customer-name').val(responseText);
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })

  // Consultar codigo do produto para associá-lo ao Pedido/Venda do cliente 
  $('#get-product').click(function () {

    const productID = $('#product-id').val();

    // Parametros de rota
    const parameters = 'productID=' + productID;

    let tableLine = "";

    $.ajax({
      type: 'GET',
      url: '/Dragsters/ConsultarProdutoID',
      data: parameters,
      success: function (data) {

        if (data.marca != undefined) {
          tableLine = `<th scope="row">${data.produtoID}</th>
          <td>${data.marca}</td>
          <td>${data.modelo}</td>
          <td>${data.descricao}</td>
          <td>${data.precoUnitario}</td>
          <td><i class="fas fa-plus-square"></i></td>`

          $('#order-product-result').html(tableLine);
        }
        else {
          alert('Produto não encontrado!')
        }
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })

});