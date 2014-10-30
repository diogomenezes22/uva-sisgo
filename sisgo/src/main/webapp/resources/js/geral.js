function aplicarDataTable(table, urlButton, textButton) {
	oTable = $(table).dataTable({
		"sDom": "T<'clear'>lfrtip",
		"oTableTools": {
			"aButtons": [{
			             "sExtends": "text",
			             "sButtonText": textButton,
			             "fnClick": function(nButton, oConfig, oFlash) {
			            	 location.href = urlButton;
			             }
			}]
		},
		"aLengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "Todos"]],
		"oLanguage": {
			"oPaginate": {
				"sFirst": "Primeira",
				"sLast": "Ultima",
				"sPrevious": "Anterior",
				"sNext": "Proxima"
			},
	        "sSearch": "Busca",
	        "sInfo": "Mostrando de _START_ a _END_ de _TOTAL_ registros",
	        "sInfoEmpty": "Nenhum resultado",
	        "sInfoFiltered": " - filtrados de um total de _MAX_ registros",
	        "sLengthMenu": "Mostrando _MENU_ registros",
	        "sLoadingRecords": "Por favor - espere...",
	        "sProcessing": "Carregando...",
	        "sZeroRecords": "Nenhum resultado foi encontrado com esses filtros!"
		}
	});
}