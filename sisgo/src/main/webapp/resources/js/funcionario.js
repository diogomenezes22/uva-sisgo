$(function() {
	
	aplicarDataTable($('#tabelaFuncionario'), $("#rootPath").val() + "/funcionario/form", "Novo Funcionario");
	
	$("#cpf").mask("999.999.999-99");
	
	$("#salario").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este funcionario?"))
			return
		event.preventDefault();
	});	
	
});