$(function() {
	
	aplicarDataTable($('#tabelaAnamnese'), $("#rootPath").val() + "/anamnese/paciente/" + $("#pacienteId").val() + "/form", "Nova Anamnese");
	
	$("#valorTotal").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir esta anamnese?"))
			return
		event.preventDefault();
	});	
	
});