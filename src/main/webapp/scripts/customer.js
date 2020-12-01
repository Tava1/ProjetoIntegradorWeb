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
});