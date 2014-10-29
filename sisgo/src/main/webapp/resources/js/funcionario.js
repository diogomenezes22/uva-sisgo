$(function() {
	
	aplicarDataTable($('#tabelaFuncionario'));
	
	$("#cpf").mask("999.999.999-99");
	
	$("#salario").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
	
});