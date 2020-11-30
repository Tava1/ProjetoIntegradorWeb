$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $('#create-role').click(function () {

    const inputTitulo = $('#role-title').val();

    const parameters = 'titulo=' + inputTitulo;

    console.log(parameters);

    $.ajax({
      type: 'POST',
      url: '/Dragsters/CriarCargo',
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