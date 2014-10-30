$(function() {
	
	aplicarDataTable($('#tabelaTratamento'));
	
	$("#valor").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este tratamento?"))
			return
		event.preventDefault();
	});
	
});