$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $('#create-branch').click(function () {
    const titulo = $('#unidade-titulo option:selected').val();
    const endereco = $('#unidade-endereco').val();
    const enderecoNumero = $('#unidade-endereco-numero').val();
    const cidade = $('#unidade-cidade').val();
    const estado = $('#unidade-estado').val();

    const parameters = `titulo=${titulo}&endereco=${endereco}&enderecoNumero=${enderecoNumero}&cidade=${cidade}&estado=${estado}`;

    console.log(parameters);

    $.ajax({
      type: 'POST',
      url: '/Dragsters/CriarUnidade',
      data: parameters,
      success: function (responseText) {
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })

  $('#update-branch').click(function () {

    const unidadeID = $('#unidade-id').val();
    const titulo = $('#unidade-titulo option:selected').val();
    const endereco = $('#unidade-endereco').val();
    const enderecoNumero = $('#unidade-endereco-numero').val();
    const cidade = $('#unidade-cidade').val();
    const estado = $('#unidade-estado').val();

    const parameters = `unidadeID=${unidadeID}&titulo=${titulo}&endereco=${endereco}&enderecoNumero=${enderecoNumero}&cidade=${cidade}&estado=${estado}`;

    console.log(parameters);

    $.ajax({
      type: 'PUT',
      url: '/Dragsters/DetalheUnidade',
      data: parameters,
      success: function (responseText) {
        console.log(responseText);
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })


});