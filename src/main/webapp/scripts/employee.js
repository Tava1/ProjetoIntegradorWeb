$(document).ready(function () {

  $('form').click(function (event) {
    event.preventDefault();
  })

  $.ajax({
    type: 'GET',
    url: '/Dragsters/BuscarCargos',
    success: function (data) {
      let optionsCargo = '<option value="0">Selecione o Cargo</option>';

      for (let key of data) {
        optionsCargo += `<option value="${key.cargoID}">${key.titulo}</option>`
      }

      $('#funcionario-cargo').html(optionsCargo);
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })

  $.ajax({
    type: 'GET',
    url: '/Dragsters/BuscarUnidades',
    success: function (data) {
      let optionsUnidade = '<option id="0" value="0">Selecione a Unidade</option>';

      for (let key of data) {
        optionsUnidade += `<option value="${key.unidadeID}">${key.endereco}</option>`
      }

      $('#funcionario-unidade').html(optionsUnidade);
    },
    fail: function () {
      alert('Nao Foi!')
    }
  })

  $('#create-employee').click(function () {

    const nome = $('#funcionario-nome').val();
    const cpf = $('#funcionario-cpf').val();
    const genero = $('#funcionario-genero option:selected').val();
    const email = $('#funcionario-email').val();
    const dataNascimento = $('#funcionario-data-nascimento').val();
    const senha = $('#funcionario-senha').val();
    const cargoID = $('#funcionario-cargo option:selected').val();
    const unidadeID = $('#funcionario-unidade option:selected').val();


    const parameters = `nome=${nome}&cpf=${cpf}&genero=${genero}&email=${email}&dataNascimento=${dataNascimento}&senha=${senha}&cargoID=${cargoID}&unidadeID=${unidadeID}`;

    console.log(parameters);

    $.ajax({
      type: 'POST',
      url: '/Dragsters/CriarFuncionario',
      data: parameters,
      success: function (responseText) {
      },
      fail: function () {
        alert('Nao Foi!')
      }
    })
  })

  $('#update-employee').click(function () {

    const funcionarioID = $('#funcionario-id').val();
    const nome = $('#funcionario-nome').val();
    const cpf = $('#funcionario-cpf').val();
    const genero = $('#funcionario-genero option:selected').val();
    const email = $('#funcionario-email').val();
    const dataNascimento = $('#funcionario-data-nascimento').val();
    const senha = $('#funcionario-senha').val();
    const cargoID = $('#funcionario-cargo option:selected').val();
    const unidadeID = $('#funcionario-unidade option:selected').val();

    const parameters = `funcionarioID=${funcionarioID}&nome=${nome}&cpf=${cpf}&genero=${genero}&email=${email}&dataNascimento=${dataNascimento}&senha=${senha}&cargoID=${cargoID}&unidadeID=${unidadeID}`;

    console.log(parameters);

    $.ajax({
      type: 'PUT',
      url: '/Dragsters/DetalheFuncionario',
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