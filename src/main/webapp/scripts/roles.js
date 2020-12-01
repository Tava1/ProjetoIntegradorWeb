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

function detalheRole(btn) {

  let cargoID = $(btn).val();
  const parameters = `cargoID=${cargoID}`;

  $.ajax({
    type: 'GET',
    url: '/Dragsters/DetalheCargo',
    data: parameters,
    success: function (responseText) {
      $("html").replaceWith(responseText);
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })
}

function deleteRole(btn) {

  let cargoID = $(btn).val();
  let parameters = 'cargoID=' + cargoID;

  console.log(parameters);

  $.ajax({
    type: 'POST',
    url: '/Dragsters/CargoController',
    data: parameters,
    success: function (responseText) {
      location.reload();
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })
}
