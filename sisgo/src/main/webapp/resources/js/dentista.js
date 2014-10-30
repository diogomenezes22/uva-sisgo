$(function() {
	
	aplicarDataTable($('#tabelaDentista'), $("#rootPath").val() + "/dentista/form", "Novo Dentista");
	
	$("#cpf").mask("999.999.999-99");
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este dentista?"))
			return
		event.preventDefault();
	});	
	
});