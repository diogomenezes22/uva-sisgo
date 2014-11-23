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
    	<link href="${rootPath}/resources/css/form.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/procedimentoConsulta.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Procedimento da Consulta</h3>
			</div>
			<form id="procedimentoConsultaForm" action="${rootPath}/procedimento-consulta/salvar" method="post" class="form-horizontal" role="form">
				<input type="hidden" id="id" name="procedimentoConsulta.id" value="${procedimentoConsulta.id}">
				<input type="hidden" id="id" name="procedimentoConsulta.consulta.id" value="${consulta.id}">
				<c:if test="${not empty procedimentoConsulta.id}">
					<div class="form-group">
						<label class="col-sm-2 control-label">Codigo</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${procedimentoConsulta.id}" readonly>
						</div>
					</div>				
				</c:if>			
				<div class="form-group">
					<label for="procedimento" class="col-sm-2 control-label">Procedimento</label>
					<div class="col-sm-10">
						<select id="procedimento" name="procedimentoConsulta.procedimento.id" class="form-control" required>
							<option value="">--</option>
							<c:forEach items="${procedimentos}" var="procedimento">
								<option value="${procedimento.id}" <c:if test="${procedimentoConsulta.procedimento.id == procedimento.id}">selected</c:if>>${procedimento.tratamento.nome} (Plano ${procedimento.planoTratamento.id})</option>
							</c:forEach>
						</select>
					</div>
				</div>																						
				<div class="form-group">
					<label for="obs" class="col-sm-2 control-label">Obs</label>
					<div class="col-sm-10">
						<input type="text" id="obs" name="procedimentoConsulta.obs" class="form-control" placeholder="Obs" value="${procedimentoConsulta.obs}">
					</div>
				</div>																
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">Salvar</button>
					</div>
				</div>
			</form>			
    	</div>

  	</body>
</html>