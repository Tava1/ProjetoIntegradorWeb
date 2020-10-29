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
          tableLine = `<th id="current-product-id" scope="row">${data.produtoID}</th>
          <td>${data.marca}</td>
          <td id="current-model">${data.modelo}</td>
          <td>${data.descricao}</td>
          <td id="current-price">${data.precoUnitario}</td>
          <td>
            <div onclick="includingItemToCart()" class="add-to-cart">
              <i class="fas fa-plus-square"></i>
            </div>  
          </td>`

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

  let productList = [];
  const productItems = {};

  $('#proceed-order').click(function () {
    console.log("Finalizar")

    getCellValues();

    const parameters = {
      'customerCPF': $('#customerCPF').text(),
      'employeeID': $('').text(),
      'UnityID': $('').text(),
      'cart': [{
        id: 1,
        amount: 12
      }]

    }

    $.ajax({
      type: 'POST',
      url: '/Dragsters/VendaController',
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


});

let totalPrice = 0.00;

function includingItemToCart() {

  // detalhes do produto
  let currentProductID = $('#current-product-id').text();
  let currentModel = $('#current-model').text();
  let currentPrice = $('#current-price').text();

  // criando o nó
  const tbodyCartDetails = document.querySelector('#cart-details');

  const tr = document.createElement('tr');
  const thID = document.createElement('th');
  const thModel = document.createElement('th');
  const thPrice = document.createElement('th');
  let thAmount = document.createElement('th');
  thAmount = document.createElement('input');

  const id = document.createTextNode(currentProductID)
  const model = document.createTextNode(currentModel)
  const price = document.createTextNode(currentPrice)


  // Inserindo o detalhe do produto em cada th
  thID.appendChild(id)
  thModel.appendChild(model)
  thPrice.appendChild(price)


  tr.appendChild(thID);
  tr.appendChild(thModel);
  tr.appendChild(thPrice);
  tr.appendChild(thAmount)

  // preco total do carrinho de produtos escolhidos
  totalPrice += parseFloat(currentPrice);

  tbodyCartDetails.appendChild(tr);


  console.log(totalPrice)
}

function getCellValues() {
  var table = document.getElementById('cart-table');
  for (var r = 1, n = table.rows.length; r < n; r++) {
    for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {
      productItems.ap
    }
  }
}