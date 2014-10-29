$(function() {
	
	aplicarDataTable($('#tabelaTratamento'));
	
	$("#valor").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
	
});