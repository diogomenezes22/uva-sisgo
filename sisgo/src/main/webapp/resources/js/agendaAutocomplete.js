$a(document).ready(function() {	
	
    $a('#patient').autocomplete({
        lookup: carregarPacientes(),
        lookupFilter: function(suggestion, originalQuery, queryLowerCase) {
            var re = new RegExp('\\b' + $a.Autocomplete.utils.escapeRegExChars(queryLowerCase), 'gi');
            return re.test(suggestion.value);
        },
        onSelect: function(suggestion) {
        	$a("#patientId").val(suggestion.data);
        }
    });
    
    $a('#dentist').autocomplete({
        lookup: carregarDentistas(),
        lookupFilter: function(suggestion, originalQuery, queryLowerCase) {
            var re = new RegExp('\\b' + $a.Autocomplete.utils.escapeRegExChars(queryLowerCase), 'gi');
            return re.test(suggestion.value);
        },
        onSelect: function(suggestion) {
        	$a("#dentistId").val(suggestion.data);
        }        
    });    
   
});


function carregarPacientes() {
	
	var pacientes;
	$.ajax({
		async: false,
		url: "/sisgo/agenda/carregar-pacientes",
		type: "post",
		dataType: "json",
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao carregar pacientes!");
		},
		success: function(pacientesJson) {
			pacientes = pacientesJson;
		}
	});	
	return pacientes;
}

function carregarDentistas() {
	
	var dentistas;
	$.ajax({
		async: false,
		url: "/sisgo/agenda/carregar-dentistas",
		type: "post",
		dataType: "json",
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao carregar dentistas!");
		},
		success: function(dentistasJson) {
			dentistas = dentistasJson;
		}
	});	
	return dentistas;
}
