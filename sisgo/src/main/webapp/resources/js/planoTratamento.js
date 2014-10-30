$(function() {
	
	aplicarDataTable($('#tabelaPlanoTratamento'));
	
	$("#valorTotal").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este plano?"))
			return
		event.preventDefault();
	});	
	
	$(document).on("click", ".opcaoTratamento", function() {
		calcularValorTotal();
	})
	
	calcularValorTotal();
	
});

function calcularValorTotal() {
	
	var valorTotal = 0.0;
	$(".opcaoTratamento:checked").each(function() {
		valorTotal += Number($(this).siblings(".valorTratamento").val());
	}); 
	$("#valorTotal").val(String(valorTotal.toFixed(2)).replace(".", ","));
	
}