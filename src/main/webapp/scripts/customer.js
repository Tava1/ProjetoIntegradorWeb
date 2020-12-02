$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $('#create-customer').click(function () {

    const nome = $('#cliente-nome').val();
    const cpf = $('#cliente-cpf').val();
    const genero = $('#cliente-genero option:selected').val();
    const estadoCivil = $('#cliente-estado-civil option:selected').val();
    const email = $('#cliente-email').val();
    const dataNascimento = $('#cliente-data-nascimento').val();
    const numeroContato = $('#cliente-numero-contato').val();
    const endereco = $('#cliente-endereco').val();
    const enderecoNumero = $('#cliente-endereco-numero').val();
    const complemento = $('#cliente-complemento').val();
    const cidade = $('#cliente-cidade').val();
    const estado = $('#cliente-estado').val();

    const parameters = `nome=${nome}&cpf=${cpf}&genero=${genero}&estadoCivil=${estadoCivil}&email=${email}&dataNascimento=${dataNascimento}&numeroContato=${numeroContato}&endereco=${endereco}&enderecoNumero=${enderecoNumero}&complemento=${complemento}&cidade=${cidade}&estado=${estado}`;

    console.log(parameters);

    $.ajax({
      type: 'POST',
      url: '/Dragsters/CriarCliente',
      data: parameters,
      success: function (responseText) {
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })


  $('#update-customer').click(function () {

    const clienteID = $('#cliente-id').val();
    const nome = $('#cliente-nome').val();
    const cpf = $('#cliente-cpf').val();
    const genero = $('#cliente-genero option:selected').val();
    const estadoCivil = $('#cliente-estado-civil option:selected').val();
    const email = $('#cliente-email').val();
    const dataNascimento = $('#cliente-data-nascimento').val();
    const numeroContato = $('#cliente-numero-contato').val();
    const endereco = $('#cliente-endereco').val();
    const enderecoNumero = $('#cliente-endereco-numero').val();
    const complemento = $('#cliente-complemento').val();
    const cidade = $('#cliente-cidade').val();
    const estado = $('#cliente-estado').val();

    const parameters = `clienteID=${clienteID}&nome=${nome}&cpf=${cpf}&genero=${genero}&estadoCivil=${estadoCivil}&email=${email}&dataNascimento=${dataNascimento}&numeroContato=${numeroContato}&endereco=${endereco}&enderecoNumero=${enderecoNumero}&complemento=${complemento}&cidade=${cidade}&estado=${estado}`;

    console.log(parameters);

    $.ajax({
      type: 'PUT',
      url: '/Dragsters/DetalheCliente' + "?" + parameters,
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

function deleteCustomer(btn) {

  let clienteID = $(btn).val();
  let parameters = 'clienteID=' + clienteID;

  $.ajax({
    type: 'POST',
    url: '/Dragsters/ClienteController',
    data: parameters,
    success: function (responseText) {
      location.reload();
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })
}
