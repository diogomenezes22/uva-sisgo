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

    	<%@ include file="../include/geral.jsp" %>
    	<link href="${rootPath}/resources/css/formAnamnese.css" rel="stylesheet">
    	<link href="${rootPath}/resources/css/anamnesePadrao.css" rel="stylesheet">
    	<link href="${rootPath}/resources/css/form.css" rel="stylesheet">
    	<link href="${rootPath}/resources/css/widgEditor.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/anamnese.js"></script>
    	<script src="${rootPath}/resources/js/widgEditor.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Anamnese</h3>
			</div>
			<form id="anamneseForm" action="${rootPath}/anamnese/salvar" method="post" role="form">
				<input type="hidden" id="id" name="anamnese.id" value="${anamnese.id}">
				<input type="hidden" id="id" name="anamnese.paciente.id" value="${paciente.id}">
				<c:if test="${not empty anamnese.id}">
					<div class="form-group">
						<label>Codigo</label>
						<input type="text" class="form-control" value="${anamnese.id}" readonly>
					</div>
				</c:if>				
				<div class="form-group">
					<div class="form-group">
						<label>Ficha de Anamnese</label>
						<textarea id="ficha" name="anamnese.ficha" class="widgEditor form-control" rows="20"><c:choose><c:when test="${empty anamnese.id}"><%@ include file="fichaPadrao.html" %></c:when><c:otherwise>${anamnese.ficha}</c:otherwise></c:choose></textarea>
					</div>
				</div>										
				<div class="form-group">
					<button type="submit" class="btn btn-success">Salvar</button>
				</div>
			</form>			
    	</div>

  	</body>
</html>