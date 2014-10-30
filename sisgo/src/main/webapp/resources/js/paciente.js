$(function() {
	
	aplicarDataTable($('#tabelaPaciente'), $("#rootPath").val() + "/paciente/form", "Novo Paciente");
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este paciente?"))
			return
		event.preventDefault();
	});	
	
});