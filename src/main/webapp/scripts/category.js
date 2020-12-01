$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $('#create-category').click(function () {

    const inputTitulo = $('#category-title').val();

    const parameters = 'titulo=' + inputTitulo;

    console.log(parameters);

    $.ajax({
      type: 'POST',
      url: '/Dragsters/CriarCategoriaProduto',
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