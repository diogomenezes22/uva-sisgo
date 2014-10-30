$(function() {
	
	aplicarDataTable($('#tabelaPaciente'));
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este paciente?"))
			return
		event.preventDefault();
	});	
	
});