<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="../../favicon.ico">

    	<title>SISGO</title>

    	<link href="${rootPath}/resources/css/agendaReset.css" rel="stylesheet">    	
		<link href="${rootPath}/resources/css/jquery-ui.forweekcalendar.css" rel="stylesheet">
		<link href="${rootPath}/resources/css/jquery.weekcalendar.css" rel="stylesheet">
		<link href="${rootPath}/resources/css/autocomplete.css" rel="stylesheet">
		<link href="${rootPath}/resources/css/agenda.css" rel="stylesheet">    	
    	
    	<script src="${rootPath}/resources/js/jquery.min.js"></script>
    	<script src="${rootPath}/resources/js/jquery.autocomplete.min.js"></script>    	    	    	    	
		<script type="text/javascript">
		 //Variavel para utilizar no jquery do autocomplete. O jquery do calendar fica igual.
		var $a = jQuery.noConflict();
		</script>
    	<script src="${rootPath}/resources/js/countries.js"></script>		
		<script src="${rootPath}/resources/js/agendaAutocomplete.js"></script>    	
    	
		<script src="${rootPath}/resources/js/jquery.forweekcalendar.js"></script>
		<script src="${rootPath}/resources/js/jquery-ui.forweekcalendar.js"></script>
    	<script src="${rootPath}/resources/js/jquery.weekcalendar.js"></script>    	    	
    	<script src="${rootPath}/resources/js/agenda.js"></script>
    	
    	    	
	</head>

	<body>

		<input type="hidden" id="pagina" value="paginaAgenda">

		<div class="container">
			<div id="calendar"></div>		
    	</div>

		<div id="formConsulta">
			<form>
				<input type="hidden" />
				<ul>
					<li>
						<span>Data: </span><span class="date_holder"></span> 
					</li>
					<li>
						<label for="start">De: </label><select id="start" name="start"></select>
					</li>
					<li>
						<label for="end">Ate: </label><select id="end" name="end"></select>
					</li>					
					<li>
						<label for="patientId">Paciente: </label><input type="text" id="patient" name="patient" />
						<input type="hidden" id="patientId" name="patientId">
						<div id="patientAutocompleteSuggestion"></div>
					</li>
					<li>
						<label for="dentistId">Dentista: </label><input type="text" id="dentist" name="dentist" />
						<input type="hidden" id="dentistId" name="dentistId">
						<div id="patientAutocompleteSuggestion"></div>
					</li>
					<li>
						<label for="obs">Obs: </label><textarea id="obs" name="obs"></textarea>
					</li>
					<li class="scheduledByItemList">
						<label for="scheduledBy">Agendado por: </label><span id="scheduledBy"></span>
					</li>					
				</ul>
			</form>
		</div>
  	</body>
</html>