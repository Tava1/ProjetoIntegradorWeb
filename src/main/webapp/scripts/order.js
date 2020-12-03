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
      success: function (data) {
        console.log(data);
        $('#result-customer-nome').text(data.nome);
        $('#result-customer-cpf').text(`CPF: ${data.CPF}`);
        $('#result-customer-endereco').text(`${data.endereco}, ${data.enderecoNumero}`);
        $('#result-customer-complemento').text(data.complemento);
        $('#result-customer-cidade').text(`${data.cidade} - ${data.estado}`);
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })

  $('#get-product').click(function () {

    const productID = $('#product-id').val();

    // Parametros de rota
    const parameters = 'productID=' + productID;

    $.ajax({
      type: 'GET',
      url: '/Dragsters/ConsultarProdutoID',
      data: parameters,
      success: function (data) {

        let productDetail = "";

        if (data.marca != undefined) {
          productDetail = `<div class="result-product">
          <div class="result-product-info">
            <div class="result-product-image">
              <span>
                <i class="fas fa-box-open"></i>
              </span>
            </div>

            <div class="result-product-context">
              <div>
                <div class="result-product-model">
                  <span><strong>Modelo:</strong></span>
                  <span>${data.modelo}</span>
                </div>
                <div class="result-product-brand">
                  <span><strong>Marca:</strong></span>
                  <span>${data.marca}</span>
                </div>
                <div class="result-product-price">
                  <span><strong>R$</strong> ${data.precoUnitario}</span>
                </div>
                <div class="result-product-code">
                  <span><strong>Código:</strong></span>
                  <span id="result-product-id">${data.produtoID}</span>
                </div>
              </div>

              <div class="result-product-stock">
                <span><strong>Estoque:</strong></span>
                <span>18</span>
              </div>
            </div>
            <!-- <input type="number" placeholder="Quantidade"> -->
          </div>

          <div onclick="includingItemToCart()" class="add-to-cart">
            <span>
              <i class="fas fa-plus-square"></i>
            </span>
          </div>
          </div>`

          $('#result-product-info').html(productDetail);
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

  let productItems = [];

  $('#proceed-order').click(function () {
    let str = {};
    const productIds = document.querySelectorAll('.cart-product-id')
    const productQuantities = document.querySelectorAll('.cart-product-quantity')

    productIds.forEach(function (currentValue, currentIndex) {
      str = { produtoID: currentValue.innerHTML, quantidade: productQuantities[currentIndex].value }
      productItems.push(str);
    })

    const clienteCPF = $('#customer-cpf').val();

    let parameters = `?clienteCPF=${clienteCPF}`;

    console.log({ produtos: productItems });

    $.ajax({
      type: 'POST',
      url: '/Dragsters/VendaController' + parameters,
      data: JSON.stringify({ produtos: productItems }),
      dataType: 'json',
      contentType: 'application/json',
      success: function (responseText) {
        alert(responseText);
        $('#customer-name').val(responseText);
      },
      error: function (responseText) {
        alert(responseText);
      },
      fail: function (text) {
        console.log(text);
        alert('Nao Foi!')
      }
    })

    productItems = [];
  })

});

var totalPrice = 0.00;


function includingItemToCart() {

  // detalhes do produto
  let currentProductID = $('#result-product-id').text();

  const parameters = 'productID=' + currentProductID;

  $.ajax({
    type: 'GET',
    url: '/Dragsters/ConsultarProdutoID',
    data: parameters,
    success: function (data) {

      console.log(data);


      let html = "";

      if (data.marca != undefined) {
        html = `<div class="cart-result-product">
          <div class="cart-result-product-info">
            <div class="cart-result-product-image">
              <span>
                <i class="fas fa-box-open"></i>
              </span>
            </div>
      
            <div class="cart-result-product-context">
              <div class="cart-result-product-context-info">
                <div class="cart-result-product-model">
                  <span><strong>Modelo:</strong></span>
                  <span id="cart-product-modelo">${data.modelo}</span>
                </div>
                <div class="cart-result-product-brand">
                  <span><strong>Marca:</strong></span>
                  <span id="cart-product-marca">${data.marca}</span>
                </div>
                <div class="cart-result-product-price">
                  <span>R$</span>
                  <span id="cart-product-preco">${data.precoUnitario}</span>
                </div>
              </div>
              <div class="cart-result-product-context-input">
                <div>
                  <span>Código</span>
                  <span class="cart-product-id">${data.produtoID}</span>
                </div>
                <input class="cart-product-quantity" type="number" placeholder="Quantidade">
              </div>
            </div>
          </div>
        </div>`

        $('#cart-products-result').append(html);
        totalPrice += data.precoUnitario
        $('#amount').text(totalPrice)

      }
      else {
        alert('Produto não encontrado!')
      }
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })

  console.log(totalPrice);

}