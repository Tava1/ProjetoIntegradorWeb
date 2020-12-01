$(document).ready(function () {

  function limpa_formulário_cep() {
    // Limpa valores do formulário de cep.
    $("input[name='rua']").val("");
    $("input[name='bairro']").val("");
    $("input[name='cidade']").val("");
    $("input[name='uf']").val("");
    $("input[name='ibge']").val("");
  }

  //Quando o campo cep perde o foco.
  $("#cep").blur(function () {

    //Nova variável "cep" somente com dígitos.
    var cep = $(this).val().replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

      //Expressão regular para validar o CEP.
      var validacep = /^[0-9]{8}$/;

      //Valida o formato do CEP.
      if (validacep.test(cep)) {

        //Preenche os campos com "..." enquanto consulta webservice.
        $("input[name='rua']").val("...");
        $("input[name='bairro']").val("...");
        $("input[name='cidade']").val("...");
        $("input[name='uf']").val("...");
        $("input[name='ibge']").val("...");

        //Consulta o webservice viacep.com.br/
        $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

          if (!("erro" in dados)) {
            //Atualiza os campos com os valores da consulta.
            $("input[name='rua']").val(dados.logradouro);
            $("input[name='bairro']").val(dados.bairro);
            $("input[name='cidade']").val(dados.localidade);
            $("input[name='uf']").val(dados.uf);
            $("input[name='ibge']").val(dados.ibge);
          } //end if.
          else {
            //CEP pesquisado não foi encontrado.
            limpa_formulário_cep();
            alert("CEP não encontrado.");
          }
        });
      } //end if.
      else {
        //cep é inválido.
        limpa_formulário_cep();
        alert("Formato de CEP inválido.");
      }
    } //end if.
    else {
      //cep sem valor, limpa formulário.
      limpa_formulário_cep();
    }
  });
});