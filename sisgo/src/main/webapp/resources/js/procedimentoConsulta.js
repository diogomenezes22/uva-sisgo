$(function() {
	
	aplicarDataTable($('#tabelaProcedimentoConsulta'), $("#rootPath").val() + "/procedimento-consulta/" + $("#consultaId").val() + "/form", "Novo Procedimento");
	
	$(document).on("submit", ".excluir", function(event) {
		if(confirm("Deseja excluir este procedimento?"))
			return
		event.preventDefault();
	});	
	
});