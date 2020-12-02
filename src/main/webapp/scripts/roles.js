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

  $('#update-role').click(function () {

    const cargoID = $('#role-id').val();
    const titulo = $('#role-titulo').val();

    const parameters = `cargoID=${cargoID}&titulo=${titulo}`;

    console.log(parameters);

    $.ajax({
      type: 'PUT',
      url: '/Dragsters/DetalheCargo',
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

function deleteRole(btn) {

  let cargoID = $(btn).val();
  let parameters = 'cargoID=' + cargoID;

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
